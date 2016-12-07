package br.acme.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import br.acme.exception.RepositorioException;
import br.acme.location.Lugar;
import br.acme.location.Viagem;
import br.acme.storage.DATABASE;
import br.acme.storage.IRepositorio;
import br.acme.storage.RepositorioSolicitante;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MotoristaPanel extends BasePanel{
	Motorista user;
	
	public MotoristaPanel() {
		super("Painel do Motorista");
	}
	
	void display(Motorista user) {
		this.user=user;
		
		//////////////////// Buttons ////////////////////
		Button btnHome = new Button("Home");
		Button btnDisponib = new Button("Disponível");
//		Button btnListarViagens = new Button("Listar Viagens");
		Button btnAlterarDados = new Button("Alterar Dados");
		Button btnExcluirConta = new Button("Excluir Conta");
		
		btnHome.setMaxWidth(Double.MAX_VALUE);
		btnDisponib.setMaxWidth(Double.MAX_VALUE);
	//	btnListarViagens.setMaxWidth(Double.MAX_VALUE);
		btnAlterarDados.setMaxWidth(Double.MAX_VALUE);
		btnExcluirConta.setMaxWidth(Double.MAX_VALUE);

		getMenuBox().getChildren().addAll(btnHome, btnDisponib,btnAlterarDados,btnExcluirConta);
		
		//////////////////// Home Page ////////////////////
		VBox home = new VBox(new Label("Olá, "+user.getNome()+"."));
		home.setAlignment(Pos.CENTER);
		
		//////////////////// Alterar Dados Page ////////////////////
		VBox boxAlterarDados = new VBox(10);
			HBox bedrock = new HBox(10);	
				VBox leftBox = new VBox(10);
					TextField nameInput = new TextField();
					MaskTextField cpfInput = new MaskTextField();
					ComboBox<String> genderInput = new ComboBox<String>();
					MaskTextField emailInput = new MaskTextField();
					PasswordField passInput = new PasswordField();
				VBox rightBox = new VBox(10);
			HBox btnBox = new HBox(10);
				Button confirmButton = new Button("Salvar", getCheckIcon());
				Button cancelButton = new Button("Cancelar", getCancelIcon());
			
		// Config controls
		boxAlterarDados.getChildren().addAll(bedrock, btnBox);
			bedrock.getChildren().addAll(leftBox, rightBox);
				leftBox.getChildren().addAll(nameInput, cpfInput, emailInput, passInput);
					nameInput.setPromptText("Nome");
					nameInput.setText(user.getNome());
					cpfInput.setPromptText("CPF");
					cpfInput.setText(user.getCpf());
					cpfInput.setMask("NNN.NNN.NNN-NN");
					emailInput.setPromptText("Email");
					emailInput.setMask("M!@I!.P!");
					emailInput.setText(user.getEmail());
					passInput.setPromptText("Senha");
					passInput.setText(user.getSenha());
				rightBox.getChildren().addAll(genderInput);
					genderInput.getItems().addAll("Masculino","Feminino");
					genderInput.getSelectionModel().select(user.getSexo());
					
			btnBox.getChildren().addAll(confirmButton, cancelButton);
			btnBox.setAlignment(Pos.CENTER);
				confirmButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						String cpf = cpfInput.getText();
						String email = emailInput.getText();
						String senha = passInput.getText();
						String nome = nameInput.getText();
						String sexo = genderInput.getValue(); 
					try{
							Motorista alterado = new Motorista(cpf, email, senha, nome, sexo, true);
							IRepositorio<Motorista> repMot = DATABASE.lerBaseMotorista();
							repMot.alterar(user.getId(), alterado);
							DATABASE.salvarEstado(repMot);
							new MotoristaPanel().display(alterado);
							getWindow().close();
						}catch(Exception e){
							new AlertWindow().display(e.getMessage());
						}
					}
				});
				cancelButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						new MotoristaPanel().display(user);
						getWindow().close();
					}
				});
		
		//////////////////// Excluir Conta Page ////////////////////
		VBox excluirBox = new VBox();
			Label aviso = new Label("Confirme sua senha para excluir sua conta.");
			PasswordField senha = new PasswordField();
			Button btnConfirm = new Button("EXCLUIR CONTA");
			
		excluirBox.getChildren().addAll(aviso, senha, btnConfirm);
			aviso.getStyleClass().addAll("lbl-large","bold");
			senha.setPromptText("Senha");
			btnConfirm.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					if(senha.getText().equals(user.getSenha())){
						IRepositorio<Motorista> repMot = DATABASE.lerBaseMotorista();
						try {
							repMot.remover(user.getId());
						} catch (RepositorioException e) {
							e.printStackTrace();
						}
						DATABASE.salvarEstado(repMot);
						new LoginWindow().display();
						getWindow().close();
					}
					else{
						new AlertWindow().display("Senha incorreta!");
						senha.clear();
					}
				}
			});
		
		//////////////////// Btn Actions ////////////////////
		btnHome.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Home");
				getContentDisplay().getChildren().add(home);
			}
		});
		btnDisponib.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				IRepositorio<Motorista> repMot = DATABASE.lerBaseMotorista();
				if(btnDisponib.getText()=="Disponível"){
					btnDisponib.setText("Ocupado");
					user.setDisponivel(false);
				}
				else {
					btnDisponib.setText("Disponível");
					user.setDisponivel(true);
				}
				try{
				repMot.alterar(user.getId(), user);
				DATABASE.salvarEstado(repMot);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		});
		btnAlterarDados.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Alterar Dados");
				getContentDisplay().getChildren().add(boxAlterarDados);
			}
		});
		btnExcluirConta.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Excluir Conta");
				getContentDisplay().getChildren().add(excluirBox);
			}
		});
		
		//////////////////// Exibition ////////////////////
		getLblNavTitle().setText("Home");
		getContentDisplay().getChildren().add(home);
		getWindow().show();
	}
	
	
	private void selectCarona(Motorista motor){
		VBox infosCaronaBox = new VBox(10);
			TextField origem = new TextField();
			TextField idOrigem = new TextField();
			TextField destino = new TextField();
			TextField idDestino = new TextField();
			ComboBox<String> formaPagamento = new ComboBox<>();
			Button btnCarona = new Button("Solicitar Carona");
		
		infosCaronaBox.getChildren().addAll(origem, idOrigem, destino, idDestino, btnCarona);
		infosCaronaBox.setAlignment(Pos.CENTER);
			origem.setPromptText("Endereço de Partida");
			idOrigem.setPromptText("Identificador de Partida");
			destino.setPromptText("Endereço de Destino");
			idDestino.setPromptText("Identificador de Destino");
			formaPagamento.getItems().addAll("À Vista", "Cartão");
			formaPagamento.setPromptText("Forma de Pagamento");
			btnCarona.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
				
				}
			});
		getContentDisplay().getChildren().clear();
		getContentDisplay().getChildren().add(infosCaronaBox);
	}
}
