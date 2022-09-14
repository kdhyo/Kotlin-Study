package six

fun sendEmailTo(email: String) {
	println("Sending email to $email")
}

fun main() {
	var email: String? = "yole@exaple.com"
	email?.let { sendEmailTo(it) }

	// null 일 시 let 안에 있는 문구는 실행되지 않는다.
	email = null
	email?.let { sendEmailTo(it) }
}
