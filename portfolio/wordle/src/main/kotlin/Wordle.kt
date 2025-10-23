import java.io.File
import java.io.FileNotFoundException
import kotlin.random.Random

fun isValid(input: String): Boolean {
    var isValid = false
    if (input.length < WORD_LENGTH) {
        printError("Not Enough Letters")
    } else if(input.length > WORD_LENGTH) {
        printError("Too Many Letters")
    } else if (input in readWordList(INPUT_WORDS_PATH)) {
        isValid = true
    } else {
        printError("Not in word list")
    }

    return isValid
}

fun readWordList(filename: String): MutableList<String> {
    val file = File(filename)

    if (!file.exists()) throw FileNotFoundException("file not found: $filename")
    require(file.extension == "txt")

    return file.bufferedReader().readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
    require(words.isNotEmpty())

    val chosenNumber = Random.nextInt(words.size) // generate a random index
    val chosenWord = words[chosenNumber] // store word at index
    words.removeAt(chosenNumber) // remove word
    return chosenWord
}

fun obtainGuess(attempt: Int): String {
    var incorrectTimes = 0

    // loop until valid word found
    while(true) {
        println("Enter guess $attempt:")
        val input = readln().lowercase().trim()

        if (isValid(input)) {
            // remove any error messages that have appeared
            if (incorrectTimes > 0) {
                repeat(incorrectTimes) {
                    // move cursor up and clear line
                    print("\u001B[1A\u001B[2K") // remove Error message
                }
                print("\u001B[1A\u001B[2K\n") // remove final error message and newline
            }
            print("\u001B[2A\u001B[2K\n") // Clear "enter guess no:" line
            return input
        }
        else {
            incorrectTimes++
        }
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
    // move cursor up and clear inputted word
    print("\u001B[1A\u001B[2K")
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

fun printError(errorString: String) {
    // move cursor up line and delete it twice
    print("\u001B[1A\u001B[2K") // remove inputted word
    print("\u001B[1A\u001B[2K") // remove errors "Enter Guess Number"
    println(errorString)
}
