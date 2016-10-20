package br.acme.users;
import br.acme.location.*;

public class Motorista extends Usuario {
	// Atributos ----------------------------------------------------------------------------------------------------
	//atributo static pertence a classe portanto nao reinicia

	private boolean disponivel;
	Viagem[] viagens = new Viagem[10];
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Motorista(String cpf, String nome, String senha, String email, String sexo, boolean disponivel) {
		//Usando o contrutor da super
		super(cpf,nome,senha,email,sexo);
		this.disponivel = disponivel;
	}

	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Viagem[] getViagens() {
		return viagens;
	}

	public void setViagens(Viagem[] viagens) {
		this.viagens = viagens;
	}

	// Métodos ----------------------------------------------------------------------------------------------------
	public void responderPedido(boolean resposta){
		if(resposta){
			
		}
	}
	
	public void historico(){
		
	}
	
	public String toString(){
		return super.toString()+" status: "+this.disponivel+viagens.toString();
	}
}
