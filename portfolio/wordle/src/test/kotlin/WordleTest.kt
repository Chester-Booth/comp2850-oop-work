import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.FileNotFoundException
import java.nio.file.Files
import kotlin.io.path.createTempDirectory
import kotlin.io.path.createTempFile
import kotlin.io.path.writeBytes
import kotlin.io.path.writeText

@Suppress("unused")
class WordleTest : StringSpec(
    {
        "evaluateGuess: all greens when guess = target" {
            withClue("all greens expected") {
                evaluateGuess("crony", "crony") shouldBe
                    List(5) { LetterColour.GREEN }
            }
        }
        "evaluateGuess: all yellow when guess contains only letters in target word but in different places" {
            withClue("all yellow") {
                evaluateGuess("bcdea", "abcde") shouldBe
                    listOf(
                        LetterColour.YELLOW,
                        LetterColour.YELLOW,
                        LetterColour.YELLOW,
                        LetterColour.YELLOW,
                        LetterColour.YELLOW,
                    )
            }
        }
        "evaluateGuess: all greys when guess contains no letters in target word" {
            withClue("all greys expected") {
                evaluateGuess("vwxyz", "abcde") shouldBe
                    List(5) { LetterColour.GREY }
            }
        }
        "evaluateGuess: multiple chars correctly assigned" {
            withClue("1st and 4th t's green") {
                evaluateGuess("ttttt", "testy") shouldBe
                    listOf(
                        LetterColour.GREEN,
                        LetterColour.GREY,
                        LetterColour.GREY,
                        LetterColour.GREEN,
                        LetterColour.GREY,
                    )
            }
        }
        "evaluateGuess: multiple yellows correctly assigned" {
            withClue("1st+2nd yellow, 5th green") {
                evaluateGuess("ttxxx", "aatta") shouldBe
                    listOf(
                        LetterColour.YELLOW,
                        LetterColour.YELLOW,
                        LetterColour.GREY,
                        LetterColour.GREY,
                        LetterColour.GREY,
                    )
            }
        }
        "evaluateGuess: repeated letter in target word and guess in same and different spots handled correctly" {
            withClue("green+yellow") {
                evaluateGuess("txxtx", "aaatt") shouldBe
                    listOf(
                        LetterColour.YELLOW,
                        LetterColour.GREY,
                        LetterColour.GREY,
                        LetterColour.GREEN,
                        LetterColour.GREY,
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
        "pickRandomWord: removes word from list" {
            withClue("removes element") {
                val words = mutableListOf("salet", "crony", "adieu")
                pickRandomWord(words)
                words.size shouldBe 2
            }
        }
        "pickRandomWord: no word in list" {
            withClue("empty list") {
                val words = mutableListOf<String>()
                shouldThrow<IllegalArgumentException> { pickRandomWord(words) }
            }
        }

        "readWordList: returns list of lines in file " {
            withClue("returns list of lines") {
                val tmp = createTempFile(suffix = ".txt")
                tmp.writeText("words\nsalet\ncrony\ntests\nwordy\nlines")

                val list = readWordList(tmp.toString())
                list shouldBe listOf("words", "salet", "crony", "tests", "wordy", "lines")

                Files.deleteIfExists(tmp)
            }
        }
        "readWordList: works with single line file" {
            val tmp = createTempFile(suffix = ".txt")
            tmp.writeText("words")

            val list = readWordList(tmp.toString())
            list shouldBe listOf("words")

            Files.deleteIfExists(tmp)
        }
        "readWordList: returns empty list is no lines in file " {
            withClue("returns empty list") {
                val tmp = createTempFile(suffix = ".txt")

                val list = readWordList(tmp.toString())
                list shouldBe listOf()

                Files.deleteIfExists(tmp)
            }
        }
        "readWordList: handles directory as error" {
            withClue("directory passed") {
                val tmp = createTempDirectory()

                shouldThrow<IllegalArgumentException> { readWordList(tmp.toString()) }

                Files.deleteIfExists(tmp)
            }
        }
        "readWordList: non-existent file is file not found error" {
            withClue("non-existent file") {
                shouldThrow<FileNotFoundException> { readWordList("not-a-file.txt") }
            }
        }
        "readWordList: not a text file" {
            withClue(".bin file") {
                val tmp = createTempFile(suffix = ".bin")
                tmp.writeBytes(ByteArray(256) { it.toByte() })

                shouldThrow<IllegalArgumentException> { readWordList(tmp.toString()) }

                Files.deleteIfExists(tmp)
            }
        }

        "isValid: word cannot be < 5 characters" {
            withClue("four char word") {
                isValid("four") shouldBe false
            }
        }
        "isValid: word cannot be > 5 characters" {
            withClue("six char input") {
                isValid("sixcha") shouldBe false
            }
        }
        "isValid: false if word not in input list" {
            withClue("word not in input list") {
                isValid("lllll") shouldBe false
            }
        }
        "isValid: word must be in input list and 5 chars" {
            withClue("word not in input list") {
                isValid("water") shouldBe true
            }
        }
    },
)
