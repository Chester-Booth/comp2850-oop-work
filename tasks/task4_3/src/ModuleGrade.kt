import kotlin.math.roundToInt
import kotlin.system.exitProcess


fun main(args: Array<String>){
    // validate args
    if (args.size != 3) {
        println("Error: 3 arguments required")
        exitProcess(1)
    }

    // sum grades and validate ints
    var total = 0
    for (n in 0..2){
        try{
            val num = args[n].toInt()
            total += num
        }
        catch (e: NumberFormatException)
        {
            println("Error: ints required as arguments")
            exitProcess(2)
        }
    }

    // find avg
    val avg = (total/3).toDouble().roundToInt()

    //print result
    println("grade is: ${avg}")
    when {
        avg >= 80 -> println("Distinction")
        avg >= 40 -> println("Pass")
        else     -> println ("Fail")
    }



}