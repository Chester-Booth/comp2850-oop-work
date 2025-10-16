import kotlin.random.Random
import java.io.File

// Implement the six required functions here
fun isValid(word: String): Boolean{
    if (word.length != 5) return false
    //if (word in readWordList("data/words.txt") ) return true
    return true
}

fun readWordList(filename: String): MutableList<String>{
   return File(filename).bufferedReader().readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String{
    val chosenNumber = Random.nextInt(words.size+1) // Generate a random index
    val chosenWord = words[chosenNumber] // Store word at index
    words.removeAt(chosenNumber) // Remove word
    return chosenWord
}

fun obtainGuess(attempt: Int): String{
    while(true){
        println("Enter guess $attempt:")
        val input = readln().lowercase()
        if (isValid(input)) return input
        println("Not in word list")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int>{
    val eval = MutableList(5){0}
    val yellowRemaining = mutableMapOf<Char, Int>()


    for (i in 0..4) { // greens and setup yellowRemaining
        if (guess[i] == target[i]){
            eval[i] = 2
        }
        else{
            // set value 0 if not in map, increment 1 if in
            yellowRemaining[target[i]] = yellowRemaining.getOrDefault(target[i],0) + 1
        }
    }

    for (i in 0..4){
        // if not green and yellows remaining
        if (eval[i] == 0 && (yellowRemaining.getOrDefault(guess[i],0)) > 0) {
            eval[i] = 1 // yellow
            // yellowRemaining[guess[i]] -= 1
            yellowRemaining[guess[i]] = yellowRemaining.getOrDefault(target[i],0) - 1
        }
    }

    return eval
}

fun displayGuess(guess: String, matches: List<Int>){
    for (i in 0..4) {
        when (matches[i]) {
            0 -> print("\u001b[30m\u001b[100m${guess[i]}")
            1 -> print("\u001b[30m\u001b[43m${guess[i]}")
            2 -> print("\u001b[30m\u001b[42m${guess[i]}")
        }
    }
    print("\u001b[0m\n")
}