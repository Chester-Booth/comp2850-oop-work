// Task 5.1.2: die rolling simulation
import kotlin.random.Random

fun main(){

    // get input
    val dieSides = readInt("Input number of die sides to roll")
    val rollTimes = readInt("Input number of times to roll")


    // roll die
    repeat(rollTimes){
        rollDie(dieSides)
    }
}



fun rollDie(sides: Int) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun readInt(textDisplayed: String): Int {
    // show message
    println(textDisplayed)

    // catch non-integer inputs and force correct input
    while(true) {
        try {
            val input = readln().toInt()
            return input
        } catch (e: NumberFormatException) {
            println("Error: Expected a Number, try again")
        }
    }

}
