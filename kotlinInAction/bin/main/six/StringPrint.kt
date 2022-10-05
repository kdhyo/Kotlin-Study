package six

class StringPrint : StringProcessor {
	override fun process(value: String) {
		println(value)
	}
}

class NullableStringPrinter : StringProcessor {
	override fun process(value: String?) {
		if (value != null) {
			println(value)
		}
	}
}

fun main() {

}
