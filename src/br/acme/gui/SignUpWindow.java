package br.acme.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SignUpWindow extends MainWindow {

	public static void main(String[] args) {
		launch(args);
	}
	
	public SignUpWindow display() {
		Stage window = new Stage();
		Scene signUpScene;
		
		BorderPane root = new BorderPane();
			VBox signUpBox = new VBox(20);
				Label title = new Label("Sign Up");
				ComboBox<String> userType = new ComboBox<String>();
				TextField nameInput = new TextField();
				MaskTextField cpfInput = new MaskTextField();
				TextField genderInput = new TextField();
				MaskTextField emailInput = new MaskTextField();
				PasswordField passInput = new PasswordField();
				// Specifics Input
				MaskTextField nascInput = new MaskTextField();
				MaskTextField phoneInput = new MaskTextField();
				// END Specifics Input
				HBox btnBox = new HBox(10);
					Button confirmButton = new Button("OK", getCheckIcon());
					Button cancelButton = new Button("Cancel", getCancelIcon());
		
		/////////////// Image Config ///////////////
		getCheckIcon().setFitHeight(20);
		getCheckIcon().setFitWidth(20);
		getCancelIcon().setFitHeight(20);
		getCancelIcon().setFitWidth(20);
				
		/////////////// Layout Config ///////////////
		root.setCenter(signUpBox);
		root.requestFocus();
		BorderPane.setMargin(signUpBox, new Insets(10, 10, 10, 10));
			//Base inputs
			signUpBox.getChildren().addAll(title, userType, nameInput, cpfInput, genderInput, emailInput,
					passInput, nascInput, phoneInput, btnBox);
			signUpBox.setAlignment(Pos.CENTER);
			signUpBox.setMaxWidth(200);
			// Specifics Inputs
				nascInput.setMask("NN/NN/NNNN");
				nascInput.setPromptText("Data de Nascimento");
				nascInput.setDisable(true);
				phoneInput.setMask("NN NNNNN-NNNN");
				phoneInput.setDisable(true);
				phoneInput.setPromptText("Número de Celular");
			//Base inputs
				// Labels
				title.getStyleClass().addAll("lb-large", "bold");
				// Inputs
				userType.getItems().addAll("Solicitante", "Motorista", "Gerente");
				userType.setPromptText("Tipo de Usuário");
				userType.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							if(userType.getValue().equals("Solicitante")){
								nascInput.setDisable(false);
								phoneInput.setDisable(false);
							}
							else{
								nascInput.setDisable(true);
								phoneInput.setDisable(true);
							}
						}
					});
				nameInput.setPromptText("Nome");
				nameInput.setFocusTraversable(false);
				cpfInput.setPromptText("CPF");
				cpfInput.setFocusTraversable(false);
				cpfInput.setMask("NNN.NNN.NNN-NN");
				genderInput.setPromptText("Sexo");
				genderInput.setFocusTraversable(false);
				emailInput.setPromptText("Email");
				emailInput.setFocusTraversable(false);
				emailInput.setMask("M!@I!.P!");
				passInput.setPromptText("Senha");
				passInput.setFocusTraversable(false);
				// Buttons
				btnBox.getChildren().addAll(confirmButton, cancelButton);
				btnBox.setAlignment(Pos.CENTER);
					confirmButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							
						}
					});
					cancelButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							window.close();
						}
					});
			
		
		/////////////// Scene Config ///////////////
		signUpScene = new Scene(root);
		signUpScene.getStylesheets().add(getCssFile());
		
		/////////////// Stage Config ///////////////
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		window.setTitle("SignUp");
		window.setScene(signUpScene);
		window.showAndWait();
		return this;
	}

}
