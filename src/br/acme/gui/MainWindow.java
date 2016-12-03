package br.acme.gui;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class MainWindow extends Application {
	/////////////// Images ///////////////
	private final String rscPath = new String("/br/acme/gui/resources/");
	private ImageView checkIcon = new ImageView(new Image(rscPath+"icons/check.png"));
	private ImageView signIcon = new ImageView(new Image(rscPath+"icons/plus-sign-in-a-black-circle.png"));
	private ImageView cancelIcon = new ImageView(new Image(rscPath+"icons/remove-button.png"));
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage window){
		/////////////// loginScene Elements  Config ///////////////
		BorderPane root = new BorderPane();
			VBox loginBox = new VBox(20);
				Label mainTitle = new Label("Projeto LPOO");
				Label subTitle = new Label("Login");
				MaskTextField userInput = new MaskTextField();
				PasswordField passInput = new PasswordField();
				HBox btnBox = new HBox(10);
					Button loginButton = new Button("Login", checkIcon);
					Button signUpButton = new Button("Sign Up", signIcon);
		
		/////////////// Image Config ///////////////
		checkIcon.setFitHeight(20);
		checkIcon.setFitWidth(20);
		signIcon.setFitHeight(20);
		signIcon.setFitWidth(20);
		
		/////////////// Layout Config ///////////////
		root.setCenter(loginBox);
		root.requestFocus();
		BorderPane.setMargin(loginBox, new Insets(-50, 10, 10, 10));// Centralize
			loginBox.getChildren().addAll(mainTitle, subTitle,userInput, passInput, btnBox);
			loginBox.setAlignment(Pos.CENTER);
			loginBox.setMaxWidth(300);
				mainTitle.getStyleClass().addAll("lb-large", "bold");
				userInput.setPromptText("Email");
				userInput.setFocusTraversable(false);// Mantém desselecionado
				userInput.setMask("M!@M!.P!");
				passInput.setPromptText("Senha");
				passInput.setFocusTraversable(false);
				btnBox.getChildren().addAll(loginButton, signUpButton);
				btnBox.setAlignment(Pos.CENTER);
					loginButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							
						}
					});
					signUpButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							MainWindow signUp = new MainWindow();
							signUp.signUpWindow();
						}
					});
		
		/////////////// Scene Config ///////////////
		Scene loginScene = new Scene(root, 800, 500);
		String css = this.getClass().getResource("resources/mainStyle.css").toExternalForm();
		loginScene.getStylesheets().add(css);
		
		/////////////// Stage Config ///////////////
		window.setResizable(false);
		window.setTitle("Projeto LPOO");
		window.setScene(loginScene);
		window.show();
	}
	
	public void signUpWindow(){
		Stage window = new Stage();
		
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
				HBox btnBox = new HBox(10);
					Button confirmButton = new Button("OK", checkIcon);
					Button cancelButton = new Button("Cancel", cancelIcon);
		
		/////////////// Image Config ///////////////
		checkIcon.setFitHeight(20);
		checkIcon.setFitWidth(20);
		cancelIcon.setFitHeight(20);
		cancelIcon.setFitWidth(20);
				
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
				//nascInput.setVisible(false);
				phoneInput.setMask("(NN)NNNNN-NNNN");
				phoneInput.setDisable(true);
				//phoneInput.setVisible(false);
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
								//nascInput.setVisible(true);
								//phoneInput.setVisible(true);
							}
							else{
								nascInput.setDisable(true);
								phoneInput.setDisable(true);
								//nascInput.setVisible(false);
								//phoneInput.setVisible(false);
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
		Scene signUpScene = new Scene(root);
		String css = this.getClass().getResource("resources/mainStyle.css").toExternalForm();
		signUpScene.getStylesheets().add(css);
		
		/////////////// Stage Config ///////////////
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		window.setTitle("SignUp");
		window.setScene(signUpScene);
		window.showAndWait();
	}
}
