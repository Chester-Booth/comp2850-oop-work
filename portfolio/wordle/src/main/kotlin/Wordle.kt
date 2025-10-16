import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean {
    return word in readWordList(INPUT_WORDS_PATH) // if word in list of valid input words then valid, else not
}

fun readWordList(filename: String): MutableList<String> = File(filename).bufferedReader().readLines().toMutableList()

fun pickRandomWord(words: MutableList<String>): String {
    val chosenNumber = Random.nextInt(words.size) // Generate a random index
    val chosenWord = words[chosenNumber] // Store word at index
    words.removeAt(chosenNumber) // Remove word
    return chosenWord
}

fun obtainGuess(attempt: Int): String {
    while(true) {
        println("Enter guess $attempt:")
        val input = readln().lowercase()
        if (isValid(input)) return input
        println("Not in word list")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val eval = MutableList(WORD_LENGTH) { GREY_CHAR_NUMBER }
    val yellowRemaining = mutableMapOf<Char, Int>()

    for (i in 0 until WORD_LENGTH) { // greens and setup yellowRemaining
        if (guess[i] == target[i]) {
            eval[i] = 2
        }
        else if (guess[i] in target) { // yellow
            // set value 0 if not in map, increment 1 if in
            yellowRemaining[guess[i]] = yellowRemaining.getOrDefault(guess[i], 0) + 1
        }
    }

    for (i in 0 until WORD_LENGTH) {
        // if not green and yellows remaining
        if (eval[i] == 0 && (yellowRemaining.getOrDefault(guess[i], 0)) > 0) {
            eval[i] = 1 // yellow
            // yellowRemaining[guess[i]] -= 1
            yellowRemaining[guess[i]] = yellowRemaining.getOrDefault(guess[i], 0) - 1
        }
    }

    return eval
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0 until WORD_LENGTH) {
        when (matches[i]) {
            GREY_CHAR_NUMBER -> print("\u001b[30m\u001b[100m${guess[i]}")
            YELLOW_CHAR_NUMBER -> print("\u001b[30m\u001b[43m${guess[i]}")
            GREEN_CHAR_NUMBER -> print("\u001b[30m\u001b[42m${guess[i]}")
        }
    }
    print("\u001b[0m\n")
}
