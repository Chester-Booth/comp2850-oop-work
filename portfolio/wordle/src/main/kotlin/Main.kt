import kotlin.system.exitProcess

const val MAX_GUESSES = 6
const val WORD_LENGTH = 5
const val GREY_CHAR_NUMBER = 0
const val YELLOW_CHAR_NUMBER = 1
const val GREEN_CHAR_NUMBER = 2
const val WORDS_PATH = "data/words.txt"
const val INPUT_WORDS_PATH = "data/input-words.txt"

fun main() {
    val wordList = readWordList(WORDS_PATH)
    val target = pickRandomWord(wordList).lowercase()

    for (i in 1..MAX_GUESSES) {
        val guess = obtainGuess(i)
        val eval = evaluateGuess(guess, target)
        displayGuess(guess, eval)
        if (eval.count { it == GREEN_CHAR_NUMBER } == WORD_LENGTH) {
            println("\uD83C\uDF89Congrats! You Win!")
            return
        }
    }
    println(":( You loose, the word was $target")
}
