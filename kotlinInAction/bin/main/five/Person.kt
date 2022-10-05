package five

data class Person(val name: String, val age: Int)

fun main() {
	val people = listOf(Person("Alice", 27), Person("Bob", 31))
	println(
		people.joinToString(" ") { it.name }
	)

	println(people.maxByOrNull(Person::age))
	println(people.maxByOrNull { p -> p.age })
	println(people.maxByOrNull { it.age })

	println(people.filter { it.age > 30 })
	println(people.map { it.name })
	println(people.map(Person::name))

	println(
		people.filter { it.age > 30 }
			.map(Person::name)
	)

	// max 를 계속 구하는 문제점이 있음.
	people.filter { it.age == people.maxByOrNull(Person::age)!!.age }

	// max 를 한 번만 구할 수 있음.
	val maxAge = people.maxByOrNull(Person::age)!!.age
	people.filter { it.age == maxAge }

	val canBeInClub27 = { p: Person -> p.age <= 27 }
	println(people.all(canBeInClub27))
	println(people.any(canBeInClub27))

	println(people.count(canBeInClub27))
	println(people.find(canBeInClub27))

	val people2 = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
	println(people2.groupBy { it.age })
}
