// Task 12.8.2: enum class for playing card suits

enum class Suit(val symbol: Char) {
    Clubs('\u2663'),
    Diamonds('\u2666'),
    Hearts('♥'),
    Spades('\u2660'),
    ;

    val plainSymbol get() = name[0]

    override fun toString() = "$symbol"
}
