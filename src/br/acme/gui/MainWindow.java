package br.acme.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage window){
		BorderPane root = new BorderPane();
			VBox loginBox = new VBox(20);
				Label mainTitle = new Label("Projeto LPOO");
				Label subTitle = new Label("Login");
				//Label userLabel = new Label("Usuário");
				//Label passLabel = new Label("Senha");
				TextField userInput = new TextField();
				TextField passInput = new TextField();
				HBox btnBox = new HBox(10);
					Button loginButton = new Button("Login");
					Button signUpButton = new Button("Sign Up");
		
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
}
