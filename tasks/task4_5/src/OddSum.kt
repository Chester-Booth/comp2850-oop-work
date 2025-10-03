import kotlin.system.exitProcess

// Task 4.5: summing odd integers with a for loop
fun main(){
    try {
        //input max
        println("Enter a number to sum up to:")
        val max = readln().toULong()

        // validate positive
        if (max < 1uL){
            println("Error: please input a positive Int")
            exitProcess(1)
        }

        // sum odd numbers
        var count :ULong = 0u
        for (n in 1uL..max step 2) {
            count += n
        }

        println(count)
    }
    catch (e: NumberFormatException) {
        println("Error: please input a positive Int")
        exitProcess(1)
    }



}

