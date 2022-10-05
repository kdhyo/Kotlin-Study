package five

fun alphabet() = with(StringBuilder()) {
		for (letter in 'A'..'Z') {
			append(letter)
		}
		append("\nNow I know the alphabet!")
		this.toString()
	}

fun alphabet2() = StringBuilder().apply {
	for (letter in 'A'..'Z') {
		append(letter)
	}
	append("\nNow I know the alphabet!")
}.toString()

fun alphabet3() = buildString {
	for (letter in 'A'..'Z') {
		append(letter)
	}
	append("\nNow I know the alphabet!")
}

fun main() {
	println(alphabet())
	println(alphabet2())
	println(alphabet3())
}
