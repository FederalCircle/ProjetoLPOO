package br.acme.users;
import br.acme.location.*;

public class Motorista extends Usuario {
	// Atributos ----------------------------------------------------------------------------------------------------
	//atributo static pertence a classe portanto nao reinicia
	private static long idIncrement =1;
	private long id;/*
	private String cpf;
	private String nome;
	private String senha;
	private String email;
	private String sexo;*/
	private boolean disponivel;
	Viagem[] viagens = new Viagem[10];
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Motorista(String cpf, String nome, String senha, String email, String sexo, boolean disponivel) {
		//Usando o contrutor da super
		super(cpf,nome,senha,email,sexo);
		//id = Ao static id atual
		this.id = idIncrement;
		//static id ++ para o objeto
		idIncrement++;
		this.disponivel = disponivel;
	}

	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
/*
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	*/public boolean isDisponivel() {
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
		return " ID "+this.id+super.toString()+" status: "+this.disponivel+viagens.toString();
	}
}
