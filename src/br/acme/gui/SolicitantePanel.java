package br.acme.gui;

import br.acme.exception.RepositorioException;
import br.acme.location.Viagem;
import br.acme.storage.DATABASE;
import br.acme.storage.IRepositorio;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class SolicitantePanel extends BasePanel{
	
	
	public SolicitantePanel() {
		super("Painel do Solicitante");
	}
	
	void display(Solicitante user) {
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
		
		//////////////////// Listar Viagens Page ////////////////////
		TableColumn<Viagem, Long> clmIdViagem = new TableColumn<>("ID");
		clmIdViagem.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Viagem, String> clmMotorista = new TableColumn<>("Motorista");
		clmNome.setCellValueFactory(new PropertyValueFactory<>("motorista.getNome()"));
		
		TableColumn<Viagem, String> clmOrigem = new TableColumn<>("Origem");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("origem"));
		
		TableColumn<Viagem, String> clmDestino = new TableColumn<>("Destino");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("destino"));
        
		TableView<Viagem> tableViagens = new TableView<>();
		tableViagens.getColumns().addAll(clmIdViagem, clmMotorista, clmOrigem, clmDestino);
		
		//////////////////// Alterar Dados Page ////////////////////
		
		
		//////////////////// Excluir Conta Page ////////////////////
		
		
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
			}
		});
		btnAlterarDados.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Alterar Dados");
			}
		});
		btnExcluirConta.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getContentDisplay().getChildren().clear();
				getLblNavTitle().setText("Excluir Conta");
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
	
}
