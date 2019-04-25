package application;

/**
 * @author Seth T. Graham
 */

import java.util.ArrayList;

public class Hand {

	// Fields
	public ArrayList<Card> cardList;

	// Constructor
	public Hand() {
		cardList = new ArrayList<Card>();
	}

	// Clear the cardList ArrayList
	public void clear() {
		cardList.clear();
	}

	// Add a Card object to the cardList ArrayList
	public void add(Card card) {
		cardList.add(card);
	}

	// Get the "Point" value of the CardValue Enum
	public int getCardValue(Card card) {
		int value = 0;
		card.getCardValue();
		return value;
	}

	// Create the Card object String in the cardList. If all Cards are face up,
	// display total points.
	public String createHand() {
		boolean allFaceUp = true;
		String str = "";
		for (Card card : cardList) {
			str += card.getCard() + "\n";
			if (!card.isFaceUp) {
				allFaceUp = false;
			}
		}
		if (allFaceUp) {
			str += "Total points = " + getPoints() + "\n";
		}
		return str;
	}

	// Display the cards to the Console.
	public void displayHand() {
		System.out.println(createHand());
	}

	// Pull a Card object from the top of the cardList ArrayList and give it to
	// another array.
	public boolean giveCard(Card card, Hand hand) {
		if (!cardList.contains(card)) {
			return false;
		} else {
			cardList.remove(card);
			hand.add(card);
			return true;
		}
	}

	// Change the status of isFaceUp in the entire cardList ArrayList.
	public void flipCards() {
		for (Card card : cardList) {
			card.flipCard();
		}
	}

	// Add the entire point value of the Hand Array.
	public int getPoints() {
		int totalPoints = 0;
		for (int i = 0; i < cardList.size(); i++) {
			totalPoints += cardList.get(i).getCardValue();
		}
		return totalPoints;
	}

}
