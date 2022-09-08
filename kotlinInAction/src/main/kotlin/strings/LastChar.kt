package strings

val String.lastChar: Char
	get() = get(length - 1)

fun main() {
	println("Kotlin".lastChar)

	val strings: List<String> = listOf("first", "second", "fourteenth")
	println(strings.last())

	val numbers: Collection<Int> = setOf(1, 14, 2)
	println(numbers.maxOrNull())
}
