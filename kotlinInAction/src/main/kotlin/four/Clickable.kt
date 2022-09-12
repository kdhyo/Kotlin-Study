package four

interface Clickable {
	fun click()
	fun showOff() = println("I'm clickable!")
}

interface Focusable {
	fun setFocus(b: Boolean) =
		println("I ${if (b) "got" else "lost"}")
	fun showOff() = println("I'm focusable!")
}

class Button: Clickable, Focusable {
	override fun click() = println("I was clicked")
	override fun showOff() {
		super<Clickable>.showOff()
		super<Focusable>.showOff()
	}
}

//internal open class TalkativeButton : Focusable {
//	private fun yell() = println("Hey!")
//	protected fun whisper() = println("Let's talk!")
//}
//
//internal fun TalkativeButton.giveSpeech() {
//	yell()
//	whisper()
//}

fun main() {
	val button = Button()
	button.showOff()
	button.setFocus(true)
	button.click()
}
