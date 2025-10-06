// Task 5.1.1: anagram checking using a function
fun main(){

    // get inputs
    println("input string1")
    val string1 = readln()

    println("input string2")
    val string2 = readln()

    // output result
    println(anagrams(string1,string2))


}





fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}