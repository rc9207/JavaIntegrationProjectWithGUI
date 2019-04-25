package application;

/**
 * 
 * @author Seth T. Graham
 *
 */

public class Card {

	// Private Fields
	private CardSuit cardSuit;
	private CardValue cardValue;

	public boolean isFaceUp;

	// Constructor

	// Blank Constructor.
	public Card() {
	}

	// "public Card(CardValue cardValue, CardSuit cardSuit)" is the header for this
	// constructor
	public Card(CardValue cardValue, CardSuit cardSuit) {
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
		isFaceUp = false;
	}

	// public Methods
	public int getCardValue() {
		return cardValue.getCardValue();
	}

	/*
	 * Create Card by combining Enum Strings. Determine if the Card is faceUp. if
	 * the card is NOT faceUp display "Card is face down";
	 */
	// Conditional operator
	public String getCard() {
		String str = "";
		if (isFaceUp) {
			str += cardValue.getCardName() + " of " + cardSuit.getCardSuit();
		} else {
			str = "Card is face down";
		}
		return str;
	}

	// Change the boolean value of the isFaceUp assignment.
	public void flipCard() {
		isFaceUp = !isFaceUp;
	}

}
