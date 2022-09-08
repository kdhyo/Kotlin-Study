package strings

fun main() {
	val set = hashSetOf<Int>(1, 7, 53)
	val list = arrayListOf<Int>(1, 7, 53)
	val map = hashMapOf<Int, String>(1 to "one", 7 to "seven", 53 to "fifty-three")

	println(set.javaClass)
	println(list.javaClass)
	println(map.javaClass)
}
