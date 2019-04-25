package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author Seth T. Graham
 *
 */

public class SplashPageController {

	// FXML variable links with Scene Builder
	@FXML
	private Button coreConceptsButton;
	@FXML
	private Button playACardGameButton;

	// Core Concepts Menu Button
	public void coreConceptsButtonPushed(ActionEvent event) throws IOException {

		Parent coreConceptsParent = FXMLLoader.load(getClass().getResource("/CoreConceptsFXML.fxml"));
		Scene coreConceptsScene = new Scene(coreConceptsParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(coreConceptsScene);
		window.show();
	}

	// Card Game Menu Button
	public void cardGameButtonPushed(ActionEvent event) throws IOException {

		Parent cardGameParent = FXMLLoader.load(getClass().getResource("/CardGameFXML.fxml"));
		Scene cardGameScene = new Scene(cardGameParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(cardGameScene);
		window.show();
	}

}
