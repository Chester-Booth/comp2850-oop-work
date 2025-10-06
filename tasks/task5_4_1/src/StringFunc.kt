// Task 5.4.1: string extension function
fun main(){

    println("input string")
    val input = readln()
    println(input.tooLong())
}

fun String.tooLong() = this.length >=  20
