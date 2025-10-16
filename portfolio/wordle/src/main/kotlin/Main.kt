import kotlin.system.exitProcess

fun main() {

    val wordList = readWordList("data/words.txt")
    val target = pickRandomWord(wordList).lowercase()
    for (i in 1..6) {
        val guess = obtainGuess(i)
        val eval = evaluateGuess(guess,target)
        displayGuess(guess,eval)
        if (eval.count { it == 2 } == 5) {
            println("\uD83C\uDF89Congrats! You Win!")
            exitProcess(0)
        }
    }
    println("You loose, the word was $target")
}
