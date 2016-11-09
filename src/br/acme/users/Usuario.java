package br.acme.users;
import br.acme.exception.*;

public abstract class Usuario {
	//Atributos-----------------------------------------------------------------------------------------------------
	private long id;
	private static long idIncrement=0;
	private String cpf;
	private String nome;
	private String senha;
	private String email;
	private String sexo;
	
	// Construtor------------------------------------------------------------------------------------------------------
	public Usuario(String cpf, String nome, String senha, String email, String sexo) throws UsersExceptions{
		idIncrement++; //Elemento estático que varia de acordo com a quantidade de objetos
		this.id = idIncrement; //Identifica o objeto a partir de um ID único
		if(cpf==null||cpf.equals(""))
			throw new NullStringException("CPF"); 
		else if(!validaCPF(cpf))
			throw new CPFInvalidoException();
		else 
			this.cpf= cpf;
		if(nome==null||nome.equals(""))throw new NullStringException("CPF"); else this.nome = nome;
		this.senha =senha;
		this.email = email;
		this.sexo = sexo;		
	}
  
	// Getters e Setters-----------------------------------------------------------------------------------------------
	public long getId() {
		return id;
	}

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
	 public long getidIncrement(){
		 return idIncrement;
	 }
	
	// Métodos-------------------------------------------------------------------------------------------
	 boolean validaCPF(String cpf){
		int[] num = new int[11];// 9 e 10 -> verificadores
		int[] sum = {0,0};
		for(int i=0, j=0; i<11; i++, j++){
			if(j==3||j==7||j==11) j++;
			num[i]=Character.getNumericValue(cpf.charAt(j));
		}
		for(int i=0, j=11; i<10; i++, j--){
			if(i!=0)sum[0]+=num[i-1]*j;
			sum[1]+=num[i]*j;
		}
		for(int i=0; i<2; i++){
			sum[i]=(sum[i]%11<2)?0:11-sum[i]%11;
		}
		return (sum[0]==num[9]&&sum[1]==num[10])?true:false;
	}
	public String toString(){
		
		return "ID: "+this.id+";Nome: "+this.nome+";CPF: "+this.cpf+";Senha: "+this.senha+";Email: "+this.email+";Sexo: "+this.sexo+";";
	}
}
