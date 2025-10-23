// Task 12.8.1: example of an enum class

enum class Day {
    Monday, Tuesday, Wednesday, Thursday,
    Friday, Saturday, Sunday
}

fun main(){
    println("Enter one of:${Day.entries}")
    try
    {
        val input = readln().trim().lowercase().replaceFirstChar {it.titlecase()}
        Day.valueOf(input)

    }
    catch(e: IllegalArgumentException){
        println("oops, that wasn't a day of the week :(")
    }


}