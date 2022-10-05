package six

fun verifyUserInput(input: String?) {
	if (input.isNullOrBlank()) {
		println("Please fill in the required fields")
	}
}
