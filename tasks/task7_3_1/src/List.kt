// Task 7.3.1: list element access
fun main(){
    val numbers = listOf(9, 3, 6, 2, 8, 5)
    println(numbers)
    println(numbers[0])
    println(numbers.get(0))
   //println(numbers[10])
    println(numbers.slice(2..4))
    println(numbers.first())
    println(numbers.last())


    val emptyList = listOf<Int>()//empty list
    //println(emptyList.first())
    //println(emptyList.last())

    //numbers[0] = 0
    //numbers.add(1)
}

