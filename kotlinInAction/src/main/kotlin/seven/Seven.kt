package seven


data class Point(val x: Int, val y: Int) {
	operator fun plus(other: Point): Point {
		return Point(x + other.x, y + other.y)
	}
}

operator fun Point.times(scale: Double): Point {
	return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
	return toString().repeat(count)
}

operator fun Point.get(index: Int): Int {
	return when (index) {
		0 -> x
		1 -> y
		else ->
			throw IndexOutOfBoundsException("Invalid coordinate $index")
	}
}

class Person(
	val firstName: String, val lastName: String
) : Comparable<Person> {
	override fun compareTo(other: Person): Int {
		return compareValuesBy(
			this, other,
			Person::lastName, Person::firstName
		)
	}

}

fun main() {
	val p1 = Point(10, 20)
	val p2 = Point(30, 40)
	println(p1 + p2)
	println(p1 * 1.5)
	println('a' * 3)

	var point = Point(1, 2)
	point += Point(3, 4)
	println(point)

	val person1 = Person("Alice", "Smith")
	val person2 = Person("Bob", "Johnson")
	println(person1 < person2)
}
