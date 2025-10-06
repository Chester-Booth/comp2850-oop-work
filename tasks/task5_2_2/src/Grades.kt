import kotlin.system.exitProcess

// Task 5.2.2: conversion of marks into grades, using a function
fun main(args: Array<String>) {

    if (args.size == 0) {
        println("Expected args")
        exitProcess(1)
    }



    for (mark in args) try {
            // for (mark in args) try{
            println("${mark} is a ${grade(mark.toInt())} ")
        } catch (e: NumberFormatException) {
            println("Error: Expected args to be ints")
        }

}



fun grade(mark: Int) = when (mark) {
    in 0..39   -> "Fail"
    in 40..69  -> "Pass"
    in 70..100 -> "Distinction"
    else       -> "?"
}
