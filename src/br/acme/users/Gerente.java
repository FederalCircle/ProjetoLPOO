package br.acme.users;

public class Gerente extends Usuario {
	// Atributos ----------------------------------------------------------------------------------------------------
	private long id;
	//atributo static pertence a classe portanto nao reinicia
		private static long idIncrement =1;
	// Construtor ----------------------------------------------------------------------------------------------------
	public Gerente(String cpf, String nome, String senha, String email, String sexo){
		//Usando o contrutor da super
		super(cpf,nome,senha,email,sexo);
		//static id ++ para o objeto
		idIncrement++;	
		//id = Ao static id atual
		this.id = idIncrement;
		
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
	*/
	// Métodos ----------------------------------------------------------------------------------------------------
	public void cadastrarMotorista(Motorista newbie){
		
	}
	
	public void removerMotorista(long id){
		
	}
	
	public void listarMotoristas(){
		
	}
	
	public void listarClientes(){
		
	}
	public String toString(){
		return " ID: "+this.id+super.toString();
	}
	
}
