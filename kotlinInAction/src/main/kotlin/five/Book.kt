package five

class Book (val title: String, val authors: List<String>)

fun main() {
	val strings = listOf("abc", "def")
	println(strings.flatMap { it.toList() })

	val books = listOf(
		Book("Thursday Next", listOf("Jasper Fforde")),
		Book("Mort", listOf("Terry Pratchett")),
		Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
	)
	println(books.flatMap { it.authors }.toSet())
}
