// Task 12.3.2: Person class, with a secondary constructor
import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    constructor(name:String,birth:String): this(name, LocalDate.parse(birth))
    var isMarried = false
}


fun main(){
    val date = LocalDate.of(2006, 6, 29)
    val person = Person("Chester","2006-06-29")

    println("${person.name} was born at ${person.birth} and Married:${person.isMarried}")
}
