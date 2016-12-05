package br.acme.tests;

import java.util.Date;

import br.acme.exception.UsersExceptions;
import br.acme.users.Solicitante;
import br.acme.users.Usuario;

public class Test {
	
	public static void main(String[] args) {
		Date dataNascimento = new Date();
		Usuario solPaula;
		try {
			solPaula = new Solicitante("407.087.551-43", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, "99112233");
			System.out.println(solPaula.getClass().getSimpleName());
		} catch (UsersExceptions e) {
			e.printStackTrace();
		}
	}

}
