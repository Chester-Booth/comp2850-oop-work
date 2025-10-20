// Task 12.5.2: class with a custom getter

import java.time.LocalDate

class Person(var _name: String, val birth: LocalDate) {
    var isMarried = false

    var name = _name
        get() {
            return field.uppercase()
        }
}
