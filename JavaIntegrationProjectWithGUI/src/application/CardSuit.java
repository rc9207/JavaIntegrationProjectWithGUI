package application;

/**
 * 
 * @author Seth T. Graham
 *
 */

public enum CardSuit {

	CLUBS("Clubs"), SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds");

	// Private field
	private final String cardSuit;

	// Constructor
	private CardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	// Public Methods
	public String getCardSuit() {
		return cardSuit;
	}

}
