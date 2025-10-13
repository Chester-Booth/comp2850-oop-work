// Task 8.3: weather station temperature analysis program

fun main() {
    // Add code here to:
    //   - Fetch data
    //   - Find records with lowest and and highest temperatures
    //   - Compute average temperature
    //   - Display all of these statistics
    val data = fetchData()
    println(data) // debug
    val lowest = data.minBy { it.second }
    val highest = data.maxBy { it.second }
    val avg = (data.sumOf { it.second } / data.size)
    println("lowest: $lowest  \nhighest: ${highest} \navg: %.2f".format(avg))

}
