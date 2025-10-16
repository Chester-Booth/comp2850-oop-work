// Task 12.3.2: Person class, with a secondary constructor
import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    constructor(name: String, birth: String) : this(name, LocalDate.parse(birth))

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    var isMarried = false
}

fun main() {
    val date = LocalDate.of(2006, 6, 29)

    println("enter name")
    val name = readln()
    println("enter dod yyyy-mm-dd")
    val dob = readln()git 

    val person = Person(name, dob)

    println("${person.name} was born at ${person.birth} and Married:${person.isMarried}")
}
