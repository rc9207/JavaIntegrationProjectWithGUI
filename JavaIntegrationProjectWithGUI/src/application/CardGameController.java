/**
 * @author Seth T. Graham
 */

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CardGameController {

	@FXML
	private Button mainMenuButton;
	@FXML
	private Button dealCardsButton;
	@FXML
	private TextField player1StandInImage;
	@FXML
	private TextField cpuStandInImage;
	@FXML
	private Label playerLabel;
	@FXML
	private Label cpuLabel;
	@FXML
	private Label resultLabel;

	public void dealCardsButtonPushed(ActionEvent event) {

		// Create and shuffle Deck
		Deck deck1 = new Deck();
		deck1.createDeck();
		deck1.shuffleDeck();

		// Create 2 hands
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		Hand[] hands = { hand1, hand2 };

		// Deal cards to your hand
		deck1.dealCards(hand1, 1);

		// Show your hand
		for (int i = 0; i < 1; i++) {
			hand1.flipCards();
			playerLabel.setText(String.valueOf(hand1.createHand()));
		}

		// Deal cards to CPUs hand
		deck1.dealCards(hand2, 1);

		// Show CPUs hand
		for (int i = 0; i < 1; i++) {
			hand2.flipCards();
			cpuLabel.setText(String.valueOf(hand2.createHand()));
		}

		// Compare Points
		if (hand1.getPoints() > hand2.getPoints()) {
			resultLabel.setText("You Win!");
		} else if (hand1.getPoints() < hand2.getPoints()) {
			resultLabel.setText("You Lose!");
		} else if (hand1.getPoints() == hand2.getPoints()) {
			resultLabel.setText("Tie!");
		}
	}

	// Return to Main Menu Button
	public void mainMenuButtonPushed(ActionEvent event) throws IOException {
		Parent splashPageParent = FXMLLoader.load(getClass().getResource("/SplashPageFXML.fxml"));
		Scene splashPageScene = new Scene(splashPageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(splashPageScene);
		window.show();
	}
}
