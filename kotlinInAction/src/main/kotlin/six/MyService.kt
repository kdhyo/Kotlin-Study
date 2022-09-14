package six

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MyService {
	fun performAction(): String = "foo"
}

class MyTest {
	private lateinit var myService: MyService

	@BeforeEach
	fun setUp() {
		myService = MyService()
	}

	@Test
	fun testAction() {
		assertEquals("foo", myService.performAction())
	}
}
