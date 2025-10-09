// Task 7.7.1: stats for a numeric dataset

fun main() {
    val numbers = readData()
    displayStats(numbers)
}

fun readData() = buildList {
    println("Input the number of numbers to add:")
    val totalNumbers = readln().toInt()

    repeat(totalNumbers){
        println("enter a floating-point number to add to the list:")
        add(readln().toFloat())
    }
}

fun median(list: List<Float>): Float{
    val sortedList = list.sorted()

    if (sortedList.size % 2 == 1){ // odd
        return sortedList[sortedList.size/2]
    }
    else{ //even
        val lowerMid = sortedList[(sortedList.size/2)-1]
        val upperMid = sortedList[sortedList.size/2]
        return (upperMid + lowerMid)/ 2f
    }
}

fun displayStats(list: List<Float>){
    println("Max:${list.max()}, Min:${list.min()}, Mean:${list.average()}, Median:${median(list)}")
}