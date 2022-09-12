package four

/**  생성자 테스트 **/
//interface User {
//	val nickname: String
//}
//
//class PrivateUser(override val nickname: String) : User
//
//class SubscribingUser(val email: String) : User {
//	override val nickname: String
//		get() = email.substringBefore('@')
//}
//
//class FacebookUser(val accountId: Int) : User {
//	override val nickname = getFacebookName(accountId)
//
//	private fun getFacebookName(accountId: Int) = "312"
//}

/**  set 테스트 **/
//class User(val name: String) {
//	var address: String = "unspecified"
//		set(value: String) {
//			println(
//				"""
//				Address was changed for $name:
//				"$field" -> "$value".""".trimIndent()
//			)
//			field = value
//		}
//}

/**  동반 객체 테스트 **/
class User private constructor(val nickname: String) {
	companion object {
		fun newSubscribingUser(email: String) =
			User(email.substringBefore('@'))
	}
}

fun main() {
	val user = User.newSubscribingUser("bob@gmail.com")
	println(user.nickname)
//	user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}
