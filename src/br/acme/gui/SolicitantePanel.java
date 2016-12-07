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

public class SolicitantePanel extends BasePanel{
	Solicitante user;
	
	public SolicitantePanel() {
		super("Painel do Solicitante");
	}
	
	void display(Solicitante user) {
		this.user=user;
		
		//////////////////// Buttons ////////////////////
		Button btnHome = new Button("Home");
		Button btnPedirCarona = new Button("Pedir Carona");
		Button btnListarViagens = new Button("Listar Viagens");
		Button btnAlterarDados = new Button("Alterar Dados");
		Button btnExcluirConta = new Button("Excluir Conta");
		
		btnHome.setMaxWidth(Double.MAX_VALUE);
		btnPedirCarona.setMaxWidth(Double.MAX_VALUE);
		btnListarViagens.setMaxWidth(Double.MAX_VALUE);
		btnAlterarDados.setMaxWidth(Double.MAX_VALUE);
		btnExcluirConta.setMaxWidth(Double.MAX_VALUE);

		getMenuBox().getChildren().addAll(btnHome, btnPedirCarona,btnListarViagens,btnAlterarDados,btnExcluirConta);
		
		//////////////////// Home Page ////////////////////
		VBox home = new VBox(new Label("Olá, "+user.getNome()+"."));
		home.setAlignment(Pos.CENTER);
		
		//////////////////// Pedir Carona Page ////////////////////
		TableColumn<Motorista, Long> clmIdMotor = new TableColumn<>("ID");
		clmIdMotor.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Motorista, String> clmNome = new TableColumn<>("Motorista");
		clmNome.setMinWidth(200);
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Motorista, String> clmEmail = new TableColumn<>("Email");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
		TableView<Motorista> tableMotorista = new TableView<>(getMotoristas());
		tableMotorista.getColumns().addAll(clmIdMotor, clmNome, clmEmail);
		tableMotorista.setRowFactory( tv -> {
		    TableRow<Motorista> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            Motorista rowData = row.getItem();
		            System.out.println(rowData.getNome());
		            selectCarona(rowData);
		        }
		    });
		    return row ;
		});
		//////////////////// Listar Viagens Page ////////////////////
		TableColumn<eViagem, Long> clmIdViagem = new TableColumn<>("ID");
		clmIdViagem.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<eViagem, String> clmMotorista = new TableColumn<>("Motorista");
		clmNome.setCellValueFactory(new PropertyValueFactory<>("motorista"));
		
		TableColumn<eViagem, String> clmOrigem = new TableColumn<>("Origem");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("origem"));
		
		TableColumn<eViagem, String> clmDestino = new TableColumn<>("Destino");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("destino"));
        
		TableView<eViagem> tableViagens = new TableView<>(getViagens());
		tableViagens.getColumns().addAll(clmIdViagem, clmMotorista, clmOrigem, clmDestino);
		
		//////////////////// Alterar Dados Page ////////////////////
		VBox boxAlterarDados = new VBox(10);
			HBox bedrock = new HBox(10);	
				VBox leftBox = new VBox(10);
					TextField nameInput = new TextField();
					MaskTextField cpfInput = new MaskTextField();
					ComboBox<String> genderInput = new ComboBox<String>();
					MaskTextField emailInput = new MaskTextField();
					PasswordField passInput = new PasswordField();
					MaskTextField nascInput = new MaskTextField();
					MaskTextField phoneInput = new MaskTextField();
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
				rightBox.getChildren().addAll(genderInput, nascInput, phoneInput);
					genderInput.getItems().addAll("Masculino","Feminino");
					genderInput.getSelectionModel().select(user.getSexo());
					nascInput.setMask("NN/NN/NNNN");
					nascInput.setPromptText("Data de Nascimento");
					nascInput.setText(new SimpleDateFormat("dd/MM/yyyy").format(user.getDataNascimento()));
					phoneInput.setMask("NNNNN-NNNN");
					phoneInput.setPromptText("Número de Celular");
					phoneInput.setText(user.getNumeroCelular());
			btnBox.getChildren().addAll(confirmButton, cancelButton);
			btnBox.setAlignment(Pos.CENTER);
				confirmButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						String cpf = cpfInput.getText();
						String email = emailInput.getText();
						String senha = passInput.getText();
						String nome = nameInput.getText();
						String sexo = genderInput.getValue(); 
						Date dataNascimento = null;
						try {
							dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascInput.getText());
						} catch (ParseException e) {
							new AlertWindow().display(e.getMessage());
						}
						String numeroCelular = phoneInput.getText();
						try{
							Solicitante alterado = new Solicitante(cpf, email, senha, nome, sexo, dataNascimento, numeroCelular);
							IRepositorio<Solicitante> repSol = DATABASE.lerBaseSolicitante();
							repSol.alterar(user.getId(), alterado);
							DATABASE.salvarEstado(repSol);
							new SolicitantePanel().display(alterado);
							getWindow().close();
						}catch(Exception e){
							new AlertWindow().display(e.getMessage());
						}
					}
				});
				cancelButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						new SolicitantePanel().display(user);
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
						IRepositorio<Solicitante> repSol = DATABASE.lerBaseSolicitante();
						try {
							repSol.remover(user.getId());
						} catch (RepositorioException e) {
							e.printStackTrace();
						}
						DATABASE.salvarEstado(repSol);
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
		btnPedirCarona.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Pedir Carona");
				getContentDisplay().getChildren().add(tableMotorista);
			}
		});
		btnListarViagens.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Listar Viagens");
				getContentDisplay().getChildren().add(tableViagens);
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
	
	private ObservableList<Motorista> getMotoristas(){
        ObservableList<Motorista> motoristas = FXCollections.observableArrayList();
        IRepositorio<Motorista> repMotoristas = DATABASE.lerBaseMotorista();
        try{
	        for(Motorista m : repMotoristas.buscarTodos()){
	        	if(m==null) break;
	        	motoristas.add(m);
	        }
        }catch(RepositorioException e){
        	getContentDisplay().getChildren().clear();
        	getContentDisplay().getChildren().add(new Label("Não há motoristas disponíveis no momento"));
        }
        return motoristas;
    }
	
	private ObservableList<eViagem> getViagens(){
        ObservableList<eViagem> infoviagens = FXCollections.observableArrayList();
        try{
	        for(Viagem v : user.getViagens().buscarTodos()){
	        	if(v==null) break;
	        	eViagem ev = new eViagem(v.getId(), v.getMotorista().getNome(), v.getOrigem().getEndereco()
	        			, v.getDestino().getEndereco());
	        	infoviagens.add(ev);
	        }
        }catch(RepositorioException e){
        	
        }
        return infoviagens;
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
					try {
						user.solicitarCarona(motor, new Lugar(origem.getText(), idOrigem.getText())
								, new Lugar(destino.getText(), idDestino.getText()), formaPagamento.getValue());
						getContentDisplay().getChildren().clear();
						getContentDisplay().getChildren().add(infosCaronaBox);
					} catch (RepositorioException e) {
						new AlertWindow().display(e.getMessage());
					}
				}
			});
		getContentDisplay().getChildren().clear();
		getContentDisplay().getChildren().add(infosCaronaBox);
	}
}
