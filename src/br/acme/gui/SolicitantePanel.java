package br.acme.gui;

import br.acme.exception.RepositorioException;
import br.acme.storage.DATABASE;
import br.acme.storage.IRepositorio;
import br.acme.users.Motorista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SolicitantePanel extends BasePanel{
	public SolicitantePanel() {
		super("Painel do Solicitante");
	}
	
	void display() {
		//////////////////// Buttons ////////////////////
		Button btnPedirCarona = new Button("Pedir Carona");
		Button btnListarViagens = new Button("ListarViagens");
		Button btnAlterarDados = new Button("Alterar Dados");
		Button btnExcluirConta = new Button("Excluir Conta");
		
		btnPedirCarona.setMaxWidth(Double.MAX_VALUE);
		btnListarViagens.setMaxWidth(Double.MAX_VALUE);
		btnAlterarDados.setMaxWidth(Double.MAX_VALUE);
		btnExcluirConta.setMaxWidth(Double.MAX_VALUE);

		getMenuBox().getChildren().addAll(btnPedirCarona,btnListarViagens,btnAlterarDados,btnExcluirConta);
		
		//////////////////// Pedir Carona Page ////////////////////
		TableColumn<Motorista, Long> clmId = new TableColumn<>("ID");
		clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Motorista, String> clmNome = new TableColumn<>("Nome");
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Motorista, String> clmEmail = new TableColumn<>("Email");
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
		TableView<Motorista> tableMotorista = new TableView<>(getMotoristas());
		tableMotorista.getColumns().addAll(clmId, clmNome, clmEmail);
		
		//////////////////// Actions ////////////////////
		btnPedirCarona.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getLblNavTitle().setText("Pedir Carona");
				getContentDisplay().getChildren().add(tableMotorista);
			}
		});
		btnListarViagens.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getLblNavTitle().setText("Listar Viagens");
			}
		});
		btnAlterarDados.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getLblNavTitle().setText("Alterar Dados");
			}
		});
		btnExcluirConta.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getLblNavTitle().setText("Excluir Conta");
			}
		});
		
		//////////////////// Exibition ////////////////////
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
