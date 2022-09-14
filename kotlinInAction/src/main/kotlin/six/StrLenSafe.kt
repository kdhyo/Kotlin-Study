package six

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun printAllCaps(s: String?) {
	val allCaps: String? = s?.uppercase()
	println(allCaps)
}

fun main() {
	strLenSafe(null)
	printAllCaps("Aa")
}
