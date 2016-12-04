package br.acme.tests;
import java.util.Date;

import br.acme.users.*;
import br.acme.location.*;

public class TesteToString {

	public static void main(String[] args) {
		try{
			Date dataNascimento = new Date();
			
			Gerente gerente = new Gerente("575.580.722-12","gerente","gerente123","gerente@gerente.com","Masculino");
			Motorista motJose = new Motorista("704.073.406-02", "Jose", "jose123", "jose@motor.com", "Masculino", true);
			Solicitante solPaula = new Solicitante("571.335.854-21", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, "99112233");
			Lugar inicio = new Lugar("Praça", "Rua Alpha, 256");
			Lugar fim = new Lugar("Mercado", "Rua Omega, 652");
			Viagem travel = new Viagem(solPaula, motJose, inicio, fim, 50, "Cartão");
			
			System.out.println(gerente.toString());
			System.out.println(motJose.toString());
			System.out.println(solPaula.toString());
			System.out.println(inicio.toString());
			System.out.println(fim.toString());
			System.out.println(travel.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
