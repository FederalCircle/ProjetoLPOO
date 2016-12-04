package br.acme.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import br.acme.users.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.acme.exception.*;
import br.acme.storage.*;

public class SignUpWindow extends MainWindow {

	//public void start(Stage window){
	public void display() {
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
				phoneInput.setMask("NNNNN-NNNN");
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
							String submition = userType.getValue()+";"+cpfInput.getText()+";"+emailInput.getText()+";"
									+passInput.getText()+";"+nameInput.getText()+";"+genderInput.getText();
							if(!nascInput.isDisabled())
								submition=submition+";"+nascInput.getText()+";"+phoneInput.getText();
							
							if(doSignUp(submition)){
								window.close();
							}
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
	}
	public boolean doSignUp(String submition){
		/* infos[] ->
		 * 0 - Tipo		| 1 - CPF
		 * 2 - Email	| 3 - Senha
		 * 4 - Nome		| 5 - Sexo
		 * 6 - Nasc		| 7 - Num
		 */
		String[] infos = submition.split(";");
		switch(infos[0]){
		case "Solicitante":
			DateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");
			try{
				Solicitante novoSoli = new Solicitante(infos[1], infos[2], infos[3], infos[4], infos[5], frmt.parse(infos[6]), infos[7]);
				IRepositorio<Solicitante> repSoli = DATABASE.lerBaseSolicitante(1);
				repSoli.adicionar(novoSoli);
				return true;
			}catch(UsersExceptions e){
				new AlertWindow().display(e.getMessage());
				return false;
			}catch(RepositorioException e){
				new AlertWindow().display(e.getMessage());
				return false;
			}catch(Exception e){
				new AlertWindow().display(e.getMessage());
				return false;
			}
		case "Motorista":
			try{
				Motorista novoMotor = new Motorista(infos[1], infos[2], infos[3], infos[4], infos[5], true);
				IRepositorio<Motorista> repMotor = DATABASE.lerBaseMotorista(1);
				repMotor.adicionar(novoMotor);
				return true;
			}catch(UsersExceptions e){
				new AlertWindow().display(e.getMessage());
				return false;
			}catch(RepositorioException e){
				new AlertWindow().display(e.getMessage());
				return false;
			}catch(Exception e){
				new AlertWindow().display(e.getMessage());
				return false;
			}
		case "Gerente":
			break;
		}
		return false;
	}
}
