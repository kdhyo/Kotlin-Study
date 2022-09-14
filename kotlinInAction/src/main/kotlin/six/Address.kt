package six

class Address(
	val streetAddress: String, val zipCode: Int,
	val city: String, val country: String
)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?) {
	override fun equals(other: Any?): Boolean {
		val otherPerson = other as? Person ?: return false

		return otherPerson.name == name &&
				otherPerson.company == company
	}

	override fun hashCode(): Int {
		var result = name.hashCode()
		result = 31 * result + (company?.hashCode() ?: 0)
		return result
	}
}

fun Person.countryName(): String = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
	val address = person.company?.address
		?: throw IllegalArgumentException("No address")
	// with 이 아니라면 println("${address.zipCode} ${address.city}, ${address.country}") 로 작성해야 한다.
	with(address) {
		println(streetAddress)
		println("$zipCode $city, $country")
	}
}

fun main() {
	val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
	val jetbrains = Company("JetBrains", address)
	val person = Person("Dmitry", jetbrains)

	val item = Item()
	printShippingLabel(person)
	printShippingLabel(Person("Alexey", null))
}

class Item() {
	private var id: Long = 0
	private var name: String = ""
	constructor(id: Long, name: String): this() {
		this.id = id
		this.name = name
	}
}
