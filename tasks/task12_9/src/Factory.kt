// Task 12.9: class implementing the Static Factory Method pattern

import java.time.LocalDate

class Person private constructor(val name: String, val birth: LocalDate) {
    companion object Factory {
        private val names = mutableSetOf<String>()

        fun create(name: String, birth: LocalDate): Person {
            require(name !in names) { "Name must be unique!" }
            names.add(name)
            return Person(name, birth)
        }
    }
}


fun main(){
    val p = Person.create("Guy", LocalDate.of(2005, 7, 16))
    //val p2 = Person.create("Guy", LocalDate.of(2006,6,29)) name must be unique
}