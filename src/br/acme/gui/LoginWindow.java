package br.acme.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LoginWindow extends MainWindow {
	
	public LoginWindow(){
		super();
	}
	
	public LoginWindow display(){
		Stage window = new Stage();
		Scene loginScene;
		/////////////// loginScene Elements  Config ///////////////
		BorderPane root = new BorderPane();
			VBox loginBox = new VBox(20);
				Label mainTitle = new Label("Projeto LPOO");
				Label subTitle = new Label("Login");
				MaskTextField userInput = new MaskTextField();
				PasswordField passInput = new PasswordField();
				HBox btnBox = new HBox(10);
					Button loginButton = new Button("Login", getCheckIcon());
					Button signUpButton = new Button("Sign Up", getSignIcon());
		
		/////////////// Layout Config ///////////////
		root.setCenter(loginBox);
		BorderPane.setMargin(loginBox, new Insets(-30, 10, 10, 10));// Centralize
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
							new SolicitantePanel().display();
							window.close();
						}
					});
					signUpButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							new SignUpWindow().display();
						}
					});
		
		/////////////// Scene Config ///////////////
		loginScene = new Scene(root, 500, 400);
		loginScene.getStylesheets().add(getCssFile());
		
		/////////////// Stage Config ///////////////
		window.setResizable(false);
		window.setTitle("Projeto LPOO");
		window.setScene(loginScene);
		window.show();
		return this;
	}
}
