package br.acme.gui;

import br.acme.exception.RepositorioException;
import br.acme.storage.DATABASE;
import br.acme.storage.IRepositorio;
import br.acme.users.Gerente;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;
import br.acme.users.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

@SuppressWarnings("unchecked")
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
				userInput.setMask("M!@M!.P!");
				passInput.setPromptText("Senha");
				btnBox.getChildren().addAll(loginButton, signUpButton);
				btnBox.setAlignment(Pos.CENTER);
					loginButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							Usuario user = login(userInput.getText(), passInput.getText());
							if(user != null){
								switch (user.getClass().getSimpleName()) {
								case "Solicitante":
									Solicitante sol = (Solicitante) user;
									new SolicitantePanel().display(sol);
									break;
								case "Motorista":
									break;
								case "Gerente":
									break;
								}
								window.close();
							}
							else{
								new AlertWindow().display("Email e/ou senha incorreto(s).");
							}
							
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
	
	private Usuario login(String email, String senha){
		IRepositorio<Solicitante> repSol = DATABASE.lerBaseSolicitante();
		IRepositorio<Motorista> repMot = DATABASE.lerBaseMotorista();
		Gerente ger = DATABASE.lerBaseGerente();
		try {
			for(Solicitante s : repSol.buscarTodos()){
				if(s==null)break;
				if(s.getEmail().equals(email) && s.getSenha().equals(senha))
					return s;
			}
		} catch (RepositorioException e) {}
		try {
			for(Motorista m : repMot.buscarTodos()){
				if(m==null)break;
				if(m.getEmail().equals(email) && m.getSenha().equals(senha))
					return m;
			}
		} catch (RepositorioException e) {}
		if(ger.getEmail().equals(email) && ger.getSenha().equals(senha))
			return ger;
		
		return null;
	}
}
