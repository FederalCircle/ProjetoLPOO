package br.acme.tests;

import java.util.Date;

import br.acme.location.*;
import br.acme.storage.*;
import br.acme.users.*;

public class TesteCaronas {
	
	public static void main(String[] args) {
		Date dataNascimento = new Date();// necessário para Solicitante
		try{
		// Criando o repositório de solicitantes
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		
		// Criando o gerente 
		Gerente gerente = new Gerente("888.888.888-88","gerente","gerente123","gerente@gerente.com","Masculino");
		
		// Criando os solicitantes
		Solicitante solPaula = new Solicitante("111.111.111-11", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, 99112233);
		Solicitante solPedro = new Solicitante("222.222.222-22", "pedro@travel.com", "pedro123", "Pedro", "Masculino", dataNascimento, 99887755);
		Solicitante solAndre = new Solicitante("333.333.333-33", "andre@travel.com", "andre123", "André", "Masculino", dataNascimento, 99332211);
		
		// Criando os motoristas
		Motorista motJose = new Motorista("333.333.333-33", "Jose", "jose123", "jose@motor.com", "Masculino", true);
		Motorista motAna = new Motorista("444.444.444-44", "Ana", "ana123", "ana@motor.com", "Feminino", true);
		Motorista motMaria = new Motorista("555.555.555-55", "Maria", "maria123", "maria@motor.com", "Feminino", true);
		
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
			if(motor==null) break;
			motor.historico();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
