package br.acme.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow extends MainWindow {
	public void display(String msg) {
		Stage window = new Stage();
		Scene alertScene;

		VBox root = new VBox();
			Label mensagem= new Label(msg);
		
		/////////////// Scene Config ///////////////
		root.getChildren().add(mensagem);
		root.setAlignment(Pos.CENTER);
		
		/////////////// Scene Config ///////////////
		alertScene = new Scene(root);
		alertScene.getStylesheets().add(getCssFile());
		
		/////////////// Stage Config ///////////////
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		window.setTitle(" ");
		window.setScene(alertScene);
		window.showAndWait();
	}
}
