import java.io.File
import java.io.FileNotFoundException
import kotlin.random.Random

fun isValid(word: String): Boolean {
    var isValid = false

    if (word.length < WORD_LENGTH) {
        println("Not Enough Letters")
    } else if(word.length > WORD_LENGTH) {
        println("Too Many Letters")
    } else if (word in readWordList(INPUT_WORDS_PATH)) {
        isValid = true
    } else {
        println("Not in word list")
    }

    return isValid
}

fun readWordList(filename: String): MutableList<String> {
    val file = File(filename)

    if (!file.exists()) throw FileNotFoundException("file not found: $filename")
    if (file.extension != "txt") throw IllegalArgumentException("file is not a text file: $filename")

    return file.bufferedReader().readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
    require(words.isNotEmpty())

    val chosenNumber = Random.nextInt(words.size) // Generate a random index
    val chosenWord = words[chosenNumber] // Store word at index
    words.removeAt(chosenNumber) // Remove word
    return chosenWord
}

fun obtainGuess(attempt: Int): String {
    while(true) {
        println("Enter guess $attempt:")
        val input = readln().lowercase().trim()
        if (isValid(input)) return input
    }
}

fun evaluateGuess(guess: String, target: String): List<LetterColour> {
    // holds evaluated colours for each char in guess
    val result = MutableList(guess.length) { LetterColour.GREY }

    // map of target letters occurrences
    val targetLetterCounts = target.groupingBy { it }.eachCount().toMutableMap()

    // Greens
    for (i in 0 until guess.length) {
        if (guess[i] == target[i]) {
            result[i] = LetterColour.GREEN
            // decrement target letter occurrences
            targetLetterCounts[guess[i]] = targetLetterCounts[guess[i]]?.minus(1) ?: 0
        }
    }

    // Yellows
    for (i in 0 until guess.length) {
        if (result[i] == LetterColour.GREEN) {
            continue // skip, already handled
        }

        // if guess char is in target counts still
        if ((targetLetterCounts[guess[i]] ?: 0) > 0) {
            result[i] = LetterColour.YELLOW
            // decrement target letter occurrences
            targetLetterCounts[guess[i]] = targetLetterCounts[guess[i]]?.minus(1) ?: 0
        }
    }

    return result
}

fun displayGuess(guess: String, matches: List<LetterColour>) {
    for (i in 0 until guess.length) {
        when (matches[i]) {
            // ansi codes to colour terminal output
            LetterColour.GREY -> print("\u001b[30m\u001b[100m${guess[i]}")
            LetterColour.YELLOW -> print("\u001b[30m\u001b[43m${guess[i]}")
            LetterColour.GREEN -> print("\u001b[30m\u001b[42m${guess[i]}")
        }
    }
    // reset ansi code + new line
    print("\u001b[0m\n")
}
