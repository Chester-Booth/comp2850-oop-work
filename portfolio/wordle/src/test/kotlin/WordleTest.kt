import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// tests for evaluateGuess ,pickRandomWord,readWordList,isValid
@Suppress("unused")
class WordleTest : StringSpec({
    "evaluateGuess: all greens when guess = target" {
        withClue("all greens expected") {
            evaluateGuess("crony", "crony") shouldBe
                List(WORD_LENGTH) { GREEN_CHAR_NUMBER }
        }
    }
    "evaluateGuess: no matches is all greys" {
        withClue("all greys expected") {
            evaluateGuess("vwxyz", "abcde") shouldBe
                List(WORD_LENGTH) { GREY_CHAR_NUMBER }
        }
    }
    "evaluateGuess: multiple chars correctly assigned" {
        withClue("1st and 4th t's green") {
            evaluateGuess("ttttt", "testy") shouldBe
                listOf(
                    GREEN_CHAR_NUMBER,
                    GREY_CHAR_NUMBER,
                    GREY_CHAR_NUMBER,
                    GREEN_CHAR_NUMBER,
                    GREY_CHAR_NUMBER,
                )
        }
    }
    "evaluateGuess: multiple yellows correctly assigned" {
        withClue("1st+2nd yellow, 5th green") {
            evaluateGuess("ttxxt", "aattt") shouldBe
                listOf(
                    YELLOW_CHAR_NUMBER,
                    YELLOW_CHAR_NUMBER,
                    GREY_CHAR_NUMBER,
                    GREY_CHAR_NUMBER,
                    GREEN_CHAR_NUMBER,
                )
        }
    }
    "pickRandomWord: always returns an element from the list" {
        withClue("returned word must be in original list") {
            repeat(10) {
                val word = pickRandomWord(mutableListOf("salet", "crony", "adieu"))
                listOf("salet", "crony", "adieu").contains(word) shouldBe true
            }
        }
    }
    "pickRandomWord: works with single element in list" {
        withClue("single element") {
            val word = pickRandomWord(mutableListOf("wordy"))
            word shouldBe "wordy"
        }
    }
    "isValid: "
})
