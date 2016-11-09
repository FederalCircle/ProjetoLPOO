package br.acme.tests;
import br.acme.users.*;
import java.util.Date;
import br.acme.exception.*;
//import br.acme.exception.*;
public class TesteUsersExceptions {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// CPF's Inválidos 
		System.out.println("> CPF's Inválidos ---");
		try{
			Gerente gerente = new Gerente("123.456.789-01","gerente","gerente123","gerente@gerente.com","Masculino");
		}catch(UsersExceptions e){
			System.out.println(e.getMessage());
		}
		try{
			Date dataNascimento = new Date();// Necessário para Solicitante
			Solicitante solPaula = new Solicitante("321.654.987-10", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, 99112233);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			Motorista motJose = new Motorista("111.222.333-45", "Jose", "jose123", "jose@motor.com", "Masculino", true);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			Date dataNascimento = new Date();// Necessário para Solicitante
			Solicitante solPaula = new Solicitante("382.832.212-30", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, 99112233);
			solPaula.setCpf("123.456.789.45", "paula123");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		// Strings vazias ou nulas.
		System.out.println("\n> Strings vazias ou nulas ---");
		try{
			Gerente gerente = new Gerente("","gerente","gerente123","gerente@gerente.com","Masculino");
		}catch(UsersExceptions e){
			System.out.println(e.getMessage());
		}
		try{
			Date dataNascimento = new Date();// necessário para Solicitante
			Solicitante solPaula = new Solicitante("382.832.212-30", "", "paula123", "Paula", "Feminino", dataNascimento, 99112233);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			Motorista motJose = new Motorista("110.473.868-60", null, "jose123", "jose@motor.com", "Masculino", true);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			Gerente gerente = new Gerente("248.414.030-43","gerente","gerente123","gerente@gerente.com","Masculino");
			gerente.setSenha(null);
		}catch(UsersExceptions e){
			System.out.println(e.getMessage());
		}
		
		// ------
		try{
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
