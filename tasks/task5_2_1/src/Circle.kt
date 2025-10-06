// Task 5.2.1: geometric properties of circles
import kotlin.math.PI

fun main (){

    val doubleInput = readDouble("Input a radius of the circle")

    println ("Circles area is %.4f".format(circleArea(doubleInput)))
    println ("Circles circumference is %.4f".format(circleCircumference(doubleInput)))


}


fun circleArea(radius: Double) = PI * radius * radius

fun circleCircumference(radius: Double) = PI * radius * 2

fun readDouble(textDisplayed: String): Double{
    // catch non-double inputs and force correct input
    while(true) {
        try {
            // show message
            println(textDisplayed)

            val input = readln().toDouble()
            return input

        } catch (e: NumberFormatException) {
            println("Error: Expected a Number (double), try again")
        }
    }
}