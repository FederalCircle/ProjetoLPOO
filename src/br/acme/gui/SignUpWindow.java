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
	
	public SignUpWindow(){
		super();
	}
	
	public void display() {
		Stage window = new Stage();
		Scene signUpScene;

		
		BorderPane root = new BorderPane();
			VBox signUpBox = new VBox(20);
				Label title = new Label("Sign Up");
				ComboBox<String> userType = new ComboBox<String>();
				TextField nameInput = new TextField();
				MaskTextField cpfInput = new MaskTextField();
				ComboBox<String> genderInput = new ComboBox<String>();
				MaskTextField emailInput = new MaskTextField();
				PasswordField passInput = new PasswordField();
				// Specifics Input
				MaskTextField nascInput = new MaskTextField();
				MaskTextField phoneInput = new MaskTextField();
				// END Specifics Input
				HBox btnBox = new HBox(10);
					Button confirmButton = new Button("OK", getCheckIcon());
					Button cancelButton = new Button("Cancel", getCancelIcon());
			
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
				phoneInput.setMask("N!-NNNN");
				phoneInput.setPromptText("N�mero de Celular");
			//Base inputs
				// Labels
				title.getStyleClass().addAll("lb-large", "bold");
				// Inputs
				userType.getItems().addAll("Solicitante");
				userType.getSelectionModel().selectFirst();
				userType.setDisable(true);
				nameInput.setPromptText("Nome");
				cpfInput.setPromptText("CPF");
				cpfInput.setMask("NNN.NNN.NNN-NN");
				genderInput.getItems().addAll("Masculino", "Feminino");
				genderInput.setPromptText("G�nero");
				genderInput.setMaxWidth(Double.MAX_VALUE);
				emailInput.setPromptText("Email");
				emailInput.setMask("M!@I!.P!");
				passInput.setPromptText("Senha");
				
				// Buttons
				btnBox.getChildren().addAll(confirmButton, cancelButton);
				btnBox.setAlignment(Pos.CENTER);
					confirmButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							String submition = userType.getValue()+";"+cpfInput.getText()+";"+emailInput.getText()+";"
									+passInput.getText()+";"+nameInput.getText()+";"+genderInput.getValue();
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
				IRepositorio<Solicitante> repSoli = DATABASE.lerBaseSolicitante();
				repSoli.adicionar(novoSoli);
				DATABASE.salvarEstado(repSoli);
				return true;
			}catch(Exception e){
				new AlertWindow().display(e.getMessage());
				return false;
			}
		case "Motorista":
			try{
				Motorista novoMotor = new Motorista(infos[1], infos[2], infos[3], infos[4], infos[5], true);
				IRepositorio<Motorista> repMotor = DATABASE.lerBaseMotorista();
				repMotor.adicionar(novoMotor);
				return true;
			}catch(Exception e){
				new AlertWindow().display(e.getMessage());
				return false;
			}
		case "Gerente":
			try{
				Gerente novoGerente = new Gerente(infos[1], infos[2], infos[3], infos[4], infos[5]);
				Gerente gerente = DATABASE.lerBaseGerente();
				if(gerente!=null){
					new AlertWindow().display("J� existe um gerente cadastrado");
					return false;
				}
				DATABASE.salvarEstado(novoGerente);
				return true;
			}catch(Exception e){
				new AlertWindow().display(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
