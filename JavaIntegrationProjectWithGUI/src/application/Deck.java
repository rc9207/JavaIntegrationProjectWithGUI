package application;

/**
 * @author Seth T. Graham
 */

import java.util.Collections;

public class Deck extends Hand {

	// Create the Deck ArrayList
	public void createDeck() {
		for (CardSuit cardSuit : CardSuit.values()) {
			for (CardValue cardValue : CardValue.values()) {
				Card card = new Card(cardValue, cardSuit);
				this.add(card);
			}
		}
	}

	// Shuffle the Deck ArrayList.
	public void shuffleDeck() {
		Collections.shuffle(cardList);
	}

	// Deal to multiple hands
	public void dealCards(Hand[] hands, int numberOfCards) {
		for (int i = 0; i < numberOfCards; i++) {
			for (int j = 0; j < hands.length; j++) {
				this.giveCard(cardList.get(0), hands[j]);
			}
		}
	}

	// Deal a card to a single hand
	public void dealCards(Hand hand, int numberOfCards) {
		for (int i = 0; i < numberOfCards; i++) {
			this.giveCard(cardList.get(0), hand);
		}
	}

	// Change the isFaceUp value of a Card object.
	public void flipCard(Card card) {
		card.flipCard();
	}
}
