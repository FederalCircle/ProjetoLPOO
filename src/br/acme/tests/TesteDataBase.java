package br.acme.tests;
import br.acme.users.*;
import br.acme.storage.*;

import java.util.Date;

import br.acme.location.*;

public class TesteDataBase {
	
	public static void main(String[] args){
		Date dataNascimento = new Date();// necess�rio para Solicitante
		try{
			// Criando o reposit�rio de solicitantes
			IRepositorio<Solicitante> repSolicitante = new RepositorioSolicitante();
			
			// Criando o gerente 
			Gerente gerente = new Gerente("084.557.751-49","gerente","gerente123","gerente@gerente.com","Masculino");
			
			// Criando os solicitantes
			Solicitante solPaula = new Solicitante("407.087.551-43", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, "99112233");
			Solicitante solPedro = new Solicitante("450.047.226-68", "pedro@travel.com", "pedro123", "Pedro", "Masculino", dataNascimento, "99887755");
			Solicitante solAndre = new Solicitante("084.557.751-49", "andre@travel.com", "andre123", "Andr�", "Masculino", dataNascimento, "99332211");
			
			// Criando os motoristas
			Motorista motJose = new Motorista("450.047.226-68", "Jose", "jose123", "jose@motor.com", "Masculino", true);
			Motorista motAna = new Motorista("084.557.751-49", "Ana", "ana123", "ana@motor.com", "Feminino", true);
			Motorista motMaria = new Motorista("407.087.551-43", "Maria", "maria123", "maria@motor.com", "Feminino", true);
			
			//Criando os lugares
			Lugar inicio = new Lugar("Pra�a", "Rua Alpha, 256");
			Lugar fim = new Lugar("Mercado", "Rua Omega, 652");
			
			// Adicionando motoristas, solicitantes e viagens aos reposit�rios
			gerente.cadastrarMotorista(motMaria);
			gerente.cadastrarMotorista(motAna);
			gerente.cadastrarMotorista(motJose);
			repSolicitante.adicionar(solPaula);
			repSolicitante.adicionar(solPedro);
			repSolicitante.adicionar(solAndre);
			
			// Solicitando as caronas
			solPaula.solicitarCarona(gerente.getRepMotor(), inicio, fim, "Cart�o");
			solPedro.solicitarCarona(gerente.getRepMotor(), inicio, fim, "� Vista");
			solAndre.solicitarCarona(gerente.getRepMotor(), inicio, fim, "Cheque");
			
			// Salvando na Database
			DATABASE.salvarEstado(gerente);
			DATABASE.salvarEstado(gerente.getRepMotor());
			DATABASE.salvarEstado(repSolicitante);
			DATABASE.salvarEstado(solPaula.getViagens());
			
			// Lendo da Database
			IRepositorio<Motorista> salvoRepMotor = DATABASE.lerBaseMotorista();
			IRepositorio<Solicitante> salvoRepSoli = DATABASE.lerBaseSolicitante();
			IRepositorio<Viagem> salvoRepViagem = DATABASE.lerBaseViagem();
			Gerente salvoGerente = DATABASE.lerBaseGerente();
			
			// Imprimindo o que foi lido
			System.out.println("\nInforma��es salvas na base de dados:");
			System.out.println(salvoRepMotor.buscar(6).toString());
			System.out.println(salvoRepSoli.buscar(3).toString());
			System.out.println(salvoRepViagem.buscar(1).toString());
			System.out.println(salvoGerente.toString());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

