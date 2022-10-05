package seven

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
	protected val changeSupport = PropertyChangeSupport(this)

	fun addPropertyChangeListener(listener: PropertyChangeListener) {
		changeSupport.addPropertyChangeListener(listener)
	}

	fun removePropertyChangeListener(listener: PropertyChangeListener) {
		changeSupport.removePropertyChangeListener(listener)
	}
}

class Person2(
	val name: String,
	age: Int, salary: Int
) : PropertyChangeAware() {
	var age: Int = age
		set(newValue) {
			val oldValue = field
			field = newValue
			changeSupport.firePropertyChange(
				"age", oldValue, newValue
			)
		}
	var salary: Int = salary
		set(newValue) {
			val oldValue = field
			field = newValue
			changeSupport.firePropertyChange(
				"salary", oldValue, newValue
			)
		}
}

/**
 * 7.21 도우미 클래스를 통해 프로퍼티 변경 통지 구현하기
 * **/

class ObservableProperty(
	var propValue: Int,
	private val changeSupport: PropertyChangeSupport
) {
	operator fun getValue(p: Person3, prop: KProperty<*>): Int = propValue
	operator fun setValue(p: Person3, prop: KProperty<*>, newValue: Int) {
		val oldValue = propValue
		propValue = newValue
		changeSupport.firePropertyChange(prop.name, oldValue, newValue)
	}
}

class Person3(
	val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
	private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
		changeSupport.firePropertyChange(prop.name, oldValue, newValue)
	}
	var age: Int by Delegates.observable(age, observer)
	var salary: Int by Delegates.observable(salary, observer)
}

class Person4 {
	private val _attributes = hashMapOf<String, String>()
	fun setAttribute(attrName: String, value: String) {
		_attributes[attrName] = value
	}

	val name: String by _attributes
}

fun main() {
	val p = Person4()
	val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
	for ((attrName, value) in data)
		p.setAttribute(attrName, value)
	println(p.name)
//	val p = Person3("Dmitry", 34, 2000)
//	p.addPropertyChangeListener { event ->
//		println(
//			"Property ${event.propertyName} changed " +
//					"from ${event.oldValue} to ${event.newValue}"
//		)
//	}
//
//	p.age = 35
//	p.salary = 2100
}
