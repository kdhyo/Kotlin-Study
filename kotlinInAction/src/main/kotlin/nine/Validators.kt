package nine

import kotlin.reflect.KClass

interface FieldValidator<in T> {
	fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
	override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
	override fun validate(input: Int) = input >= 0
}

object Validators {
	private val validators =
		mutableMapOf<KClass<*>, FieldValidator<*>>()

	fun <T : Any> registerValidator(
		kClass: KClass<T>, filedValidator: FieldValidator<T>
	) {
		validators[kClass] = filedValidator
	}

	@Suppress("UNCHECKED_CAST")
	operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
		validators[kClass] as? FieldValidator<T>
			?: throw IllegalArgumentException(
				"No validator for ${kClass.simpleName}"
			)
}

fun main() {
	Validators.registerValidator(String::class, DefaultStringValidator)
	Validators.registerValidator(Int::class, DefaultIntValidator)
	println(Validators[String::class].validate("Kotlin"))
//	println(Validators[String::class].validate(42)) // The integer literal does not conform to the expected type String
	println(Validators[Int::class].validate(42))
//	println(Validators[Double::class].validate(40.2)) // No validator for Double
}
