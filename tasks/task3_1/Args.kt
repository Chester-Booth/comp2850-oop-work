import kotlin.system.exitProcess

fun main(args:Array<String>){
    if (args.size == 2){
        println(args[0])
        println(args[1])
    }
    else{
        println("Error: two arguments required.")
        exitProcess(1)
    }
}// Task 3.1: command line arguments
