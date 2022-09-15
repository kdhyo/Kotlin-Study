package six

fun addValidNumbers(numbers: List<Int?>) {
	val validNumbers = numbers.filterNotNull()
	println("Sum of valid numbers: ${validNumbers.sum()}")
	println("Invalid numbers: ${numbers.size - validNumbers.size}")
}
