// Task 12.8.2: class to represent playing cards

class Card(val rank: Rank, val suit: Suit) {
    val fullName = "$rank of $suit"

    override fun toString() = "${suit.symbol}${rank.symbol}"
}
