import kotlin.system.exitProcess

// Task 4.5: summing odd integers with a for loop
fun main(){
    try {
        //input max
        println("Enter a number to sum up to:")
        val max = readln().toULong()

        // validate positive or beyond 2^64 -1 (U Long Limit)
        if (max < 1uL){
            println("Error: please input a positive Int")
            exitProcess(1)
        }

        // sum odd numbers
        var count :ULong = 0u
        for (n in 1uL..max step 2) {
            count += n
            // if overflowed
            if (count == 0uL){
                println("Error: sum of Odds exceeded 2^64")
                exitProcess(3)
            }
        }

        println(count)
    }
    catch (e: NumberFormatException) {
        println("Error: please input a positive Int")
        exitProcess(2)
    }



}

