package six

fun ignoreNulls(s: String?) {
	val sNotNull: String = s!!
	println(sNotNull.length)
}

fun main() {
	ignoreNulls(null)
}
