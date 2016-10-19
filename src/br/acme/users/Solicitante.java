package br.acme.users;
import java.util.Date;

import br.acme.location.*;

public class Solicitante {
	// Atributos ----------------------------------------------------------------------------------------------------
	private long id;
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	private String sexo;
	private Date dataNascimento = new Date();
	private int numeroCelular;
	private Lugar[] lugares = new Lugar[10];
	private Viagem[] viagens = new Viagem[10];
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Solicitante(long id, String cpf, String email, String senha, String nome, String sexo, Date dataNascimento, int numeroCelular) {
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.numeroCelular = numeroCelular;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Lugar[] getLugares() {
		return lugares;
	}

	public void setLugares(Lugar[] lugares) {
		this.lugares = lugares;
	}

	public Viagem[] getViagens() {
		return viagens;
	}

	public void setViagens(Viagem[] viagens) {
		this.viagens = viagens;
	}	
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void solicitarCarona(){
		
	}
	
	public void cancelarCarona(){
		
	}
	
	public void historico(){
		
	}
}
