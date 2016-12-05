package br.acme.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

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
		
		//////////////////// Actions ////////////////////
		btnPedirCarona.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				getLblNavTitle().setText("Pedir Carona");
			}
		});
		
		//////////////////// Exibition ////////////////////
		getWindow().show();
	}
}
