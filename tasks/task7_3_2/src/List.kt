// Task 7.3.1: list element access
fun main(){
    val numbers = mutableListOf(9, 3, 6, 2, 8, 5)
    println(numbers)
    println(numbers[0])
    println(numbers.get(0))
    //println(numbers[10])
    println(numbers.slice(2..4))
    println(numbers.first())
    println(numbers.last())


    val emptyList = listOf<Int>()//empty list
    // println(emptyList.first())
    //println(emptyList.last())

    numbers[0] = 0
    numbers.add(1)
    println(numbers)



    numbers.addAll(listOf(1,2,3,4,5,6,7,8,9,3,3,3))
    println(numbers)

    numbers.remove(3)
    println(numbers)

    numbers.removeAll(listOf(3,6))
    println(numbers)

    numbers.removeAt(3)
    println(numbers)

    numbers.clear()
    println(numbers)




}

