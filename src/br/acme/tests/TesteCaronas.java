package br.acme.tests;

import java.util.Date;

import br.acme.location.*;
import br.acme.storage.*;
import br.acme.users.*;

public class TesteCaronas {
	
	public static void main(String[] args) {
		Date dataNascimento = new Date();// necessário para Solicitante
		
		try{
		DATABASE database = new DATABASE("teste");
		// Criando o repositório de solicitantes
		IRepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		
		// Criando o gerente 
		Gerente gerente = new Gerente("084.557.751-49","gerente","gerente123","gerente@gerente.com","Masculino");
		
		// Criando os solicitantes
		Solicitante solPaula = new Solicitante("407.087.551-43", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, 99112233);
		Solicitante solPedro = new Solicitante("450.047.226-68", "pedro@travel.com", "pedro123", "Pedro", "Masculino", dataNascimento, 99887755);
		Solicitante solAndre = new Solicitante("084.557.751-49", "andre@travel.com", "andre123", "André", "Masculino", dataNascimento, 99332211);
		
		// Criando os motoristas
		Motorista motJose = new Motorista("450.047.226-68", "Jose", "jose123", "jose@motor.com", "Masculino", true);
		Motorista motAna = new Motorista("084.557.751-49", "Ana", "ana123", "ana@motor.com", "Feminino", true);
		Motorista motMaria = new Motorista("407.087.551-43", "Maria", "maria123", "maria@motor.com", "Feminino", true);
		
		//Criando os lugares
		Lugar inicio = new Lugar("Praça", "Rua Alpha, 256");
		Lugar fim = new Lugar("Mercado", "Rua Omega, 652");
		
		// Adicionando motoristas e solicitantes aos repositórios
		gerente.cadastrarMotorista(motMaria);
		gerente.cadastrarMotorista(motAna);
		gerente.cadastrarMotorista(motJose);
		repSolicitante.adicionar(solPaula);
		repSolicitante.adicionar(solPedro);
		repSolicitante.adicionar(solAndre);
		
		//Solicitando as caronas
		try{
		solPaula.solicitarCarona(gerente.getRepMotor(), inicio, fim, "Cartão");
		solPedro.solicitarCarona(gerente.getRepMotor(), inicio, fim, "à Vista");
		solAndre.solicitarCarona(gerente.getRepMotor(), inicio, fim, "Cheque");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//Listando todas as viagens feitas
		for(Motorista motor: gerente.getRepMotor().getListaMotorista()){
			if(motor==null) break;
			
			motor.historico();
		}
		
		// Cancelando carona
		solPedro.cancelarCarona();
		
		//Listando todas as viagens feitas
		for(Motorista motor: gerente.getRepMotor().getListaMotorista()){
			try{if(motor==null) break;
			motor.historico();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		 }
		database.salvarEstado(gerente.getRepMotor(),"nome");
		//database.salvarEstado(repSolicitante);
		IRepositorioMotorista b = database.lerBaseMotorista("nome");
		for(Motorista motor: b.getListaMotorista()){
			try{if(motor==null) break;
			motor.historico();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		 }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
