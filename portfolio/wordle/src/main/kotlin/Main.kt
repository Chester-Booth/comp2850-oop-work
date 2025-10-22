import java.io.File

const val MAX_GUESSES = 6
const val WORD_LENGTH = 5
const val WORDS_PATH = "data/words.txt"
const val INPUT_WORDS_PATH = "data/input-words.txt"

fun main() {
    val wordList = readWordList(WORDS_PATH)
    val target = pickRandomWord(wordList).lowercase()

    for (i in 1..MAX_GUESSES) {
        val guess = obtainGuess(i)
        val eval = evaluateGuess(guess, target)
        displayGuess(guess, eval)
        if (eval.count { it == LetterColour.GREEN } == target.length) {
            println("\uD83C\uDF89Congrats! You Win!")
            return
        }
    }
    println(":( You loose, the word was $target")
}

enum class LetterColour(val value: Int) {
    GREY(0),
    YELLOW(1),
    GREEN(2),
}
