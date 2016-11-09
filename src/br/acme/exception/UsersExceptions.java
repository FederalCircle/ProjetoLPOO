package br.acme.exception;

@SuppressWarnings("serial")
public class UsersExceptions extends Exception {
	
	public UsersExceptions (String msg){
		super("ERRO: "+msg);
	}
}
