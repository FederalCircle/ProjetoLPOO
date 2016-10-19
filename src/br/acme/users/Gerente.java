package br.acme.users;

public class Gerente {
	// Atributos ----------------------------------------------------------------------------------------------------
	private long id;
	private String cpf;
	private String nome;
	private String senha;
	private String email;
	private String sexo;
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Gerente(long id, String cpf, String nome, String senha, String email, String sexo){
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
	}

	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void cadastrarMotorista(Motorista newbie){
		
	}
	
	public void removerMotorista(long id){
		
	}
	
	public void listarMotoristas(){
		
	}
	
	public void listarClientes(){
		
	}
}
