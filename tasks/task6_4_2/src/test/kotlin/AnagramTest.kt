// Task 6.4.2

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class AnagramTest: StringSpec({
    // Write your unit tests here!
    "Two strings of different lengths are not anagrams"{
        withClue("First=x Second=xx") { "x".anagramOf("xx") shouldBe false}
        withClue("First=xx Second=x") { "xx".anagramOf("x") shouldBe false}
        withClue("First=x Second=x") { "x".anagramOf("x") shouldBe true}
    }
    "An empty string is not an anagram of itself"{
        withClue("First= Second=") { "".anagramOf("") shouldBe false}

    }
    "A non-empty string is an anagram of itself"{
        withClue("First=x Second=x") { "x".anagramOf("x") shouldBe true}
        withClue("First=words Second=words") { "words".anagramOf("words") shouldBe true}
    }
    "Two strings are anagrams if they contain the same characters in a different order"{
        withClue("First=dog Second=god") { "dog".anagramOf("god") shouldBe true}
        withClue("First=below Second=elbow") { "below".anagramOf("elbow") shouldBe true}
        withClue("First=abcd Second=wxyz") { "abcd".anagramOf("wxyz") shouldBe false}
        withClue("First=abcda Second=abcdd") { "abcda".anagramOf("abcdd") shouldBe false}

    }
    "Letter case is disregarded when comparing character sequences, i.e., the lowercase and uppercase forms of a character are considered to be equivalent"{
        withClue("First=dog Second=GOD") { "dog".anagramOf("GOD") shouldBe true}
        withClue("First=Dog Second=god") { "Dog".anagramOf("god") shouldBe true}
        withClue("First=dog Second=goD") { "dog".anagramOf("goD") shouldBe true}
    }
})
