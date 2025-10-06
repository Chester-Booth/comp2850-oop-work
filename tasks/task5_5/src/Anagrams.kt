// Task 5.1.1: anagram checking using a function
fun main(){

    // get inputs
    println("input string1")
    val string1 = readln()

    println("input string2")
    val string2 = readln()

    // output result
    if(string1 anagramOf string2 ){
        println("yes")
    }
    else{
        println("no")
    }


}



infix fun String.anagramOf(str: String): Boolean {
    if (this.length != str.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = str.lowercase().toList().sorted()
    return firstChars == secondChars
}
