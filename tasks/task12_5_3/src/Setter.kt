// Task 12.5.3: class with a custom setter

import java.time.LocalDate

class Person(var _name: String, val birth: LocalDate) {
    var isMarried = false

    var name = _name
        set(value) {
            require(value.isNotBlank()) { "Name cannot be blank" }
            field = value
        }
}



