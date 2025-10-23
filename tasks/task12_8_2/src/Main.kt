// Task 12.8.2: program to manipulate playing cards

// Creates a mutable list of Card objects, to represent a deck of cards
// Populates that list with a full set of 52 standard playing cards
// Shuffles the deck randomly
// Prints the full name of each card in the shuffled deck

fun main() {
    val deck = mutableListOf<Card>()

    // add cards to deck
    for (suit in Suit.entries) {
        for (rank in Rank.entries) {
            deck.add(Card(rank, suit))
        }
    }

    deck.shuffle()

    for (card in deck) {
        println(card.fullName)
    }
}
