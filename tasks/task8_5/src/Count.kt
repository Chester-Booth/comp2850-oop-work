import kotlin.reflect.typeOf

fun main(){

    val test = "hello world"
    println(test.howMany() {it in "aeiou"} )
    println(test.howMany() {it == 'o'} )
    println(test.howMany() {n: Char -> n.toString() == "e"} )
    println(test.howMany() {it.isLowerCase() } )
    println(test.howMany() {it.isUpperCase() } )
    println(test.howMany() {it.isDigit() } )
    println(test.howMany() {it.isDigit() } )
    println(test.howMany() {it.isWhitespace() } )
    println(test.howMany() { !it.isLetterOrDigit() } )
1


}

fun String.howMany(include: (Char) -> Boolean): Int {
    var count = 0
    for (character in this) {
        if (include(character)) {
            count += 1
        }
    }
    return count
}
