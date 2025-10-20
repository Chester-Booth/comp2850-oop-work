import java.time.LocalDate

fun main() {
    val string = ""
    val p = Person(string, LocalDate.of(2006, 6, 29))
    p.name = ""
    println("Name is ${p.name}")
}
