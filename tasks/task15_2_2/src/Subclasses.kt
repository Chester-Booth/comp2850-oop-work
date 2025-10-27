// Task 15.2.2: constructors in subclasses

open class Person(val name: String) {
    init {
        println("Person constructor invoked")
    }
}

class Student(name: String, val degree: String): Person(name) {
    init {
        println("Student constructor invoked")
    }
}

fun main() {
    val student = Student("Sarah", "Computer Science")
    println(student.name)
    println(student.degree)
}
