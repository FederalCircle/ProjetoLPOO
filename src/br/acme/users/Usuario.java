package br.acme.users;

public class Usuario {
	//Atributos-----------------------------------------------------------------------------------------------------
	private String cpf;
	private String nome;
	private String senha;
	private String email;
	private String sexo;
	//contrutor------------------------------------------------------------------------------------------------------
	public Usuario(String cpf, String nome, String senha, String email, String sexo){
		this.cpf= cpf;
		this.nome = nome;
		this.senha =senha;
		this.email = email;
		this.sexo = sexo;		
	}
  
	//Getters e Setters-----------------------------------------------------------------------------------------------
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf=cpf;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getSenha(){
		return senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getSexo(){
		return sexo;
	}
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	//métodos-------------------------------------------------------------------------------------------
	public String toString(){
		
		return " nome: "+this.nome+" cpf: "+this.cpf+" senha: "+this.senha+" email: "+this.email+" sexo: "+this.sexo;
	}
}
