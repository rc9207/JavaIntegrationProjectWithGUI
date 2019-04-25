package application;

/**
 * 
 * @author Seth T. Graham
 *
 */

public enum CardValue {

	ACE(1, "Ace"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"),
	EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");

	// Private fields.
	private final int cardValue;
	private final String cardName;

	// Constructor
	private CardValue(int cardValue, String cardName) {
		this.cardName = cardName;
		this.cardValue = cardValue;
	}

	// Public Methods
	public int getCardValue() {
		return cardValue;
	}

	public String getCardName() {
		return cardName;
	}

}
