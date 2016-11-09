package br.acme.exception;

@SuppressWarnings("serial")
public class CPFInvalidoException extends UsersExceptions {
	
	public CPFInvalidoException(){
		super("CPF inválido.");
	}
}
