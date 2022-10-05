package seven

data class NameComponents(
	val name: String,
	val extension: String
)

fun splitFilename(fullName: String): NameComponents {
	val (name, ext) = fullName.split('.', limit = 2)
	return NameComponents(name, ext)
}

fun main() {
	val (name, ext) = splitFilename("example.kt")
	println(name)
	println(ext)
}

