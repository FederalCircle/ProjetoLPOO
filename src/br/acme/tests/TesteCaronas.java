package br.acme.tests;

import java.util.Date;

import br.acme.location.*;
import br.acme.storage.*;
import br.acme.users.*;

public class TesteCaronas {
	
	public static void main(String[] args) {
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
			
			// Adicionando motoristas e solicitantes aos reposit�rios
			gerente.cadastrarMotorista(motMaria);
			gerente.cadastrarMotorista(motAna);
			gerente.cadastrarMotorista(motJose);
			repSolicitante.adicionar(solPaula);
			repSolicitante.adicionar(solPedro);
			repSolicitante.adicionar(solAndre);
			
			//Solicitando as caronas
			solPaula.solicitarCarona(motJose, inicio, fim, "Cart�o");
			solPedro.solicitarCarona(motAna, inicio, fim, "� Vista");
			solAndre.solicitarCarona(motMaria, inicio, fim, "Cheque");
			
			//Listando todas as viagens feitas
			for(Object motor: gerente.getRepMotor().getLista()){
				if(motor==null) break;
				((Motorista) motor).historico();
			}
			
			// Cancelando carona
			solPedro.cancelarCarona();
			
			//Listando todas as viagens feitas
			for(Object motor: gerente.getRepMotor().getLista()){
				if(motor==null) break;
				((Motorista)motor).historico();
			 }
			System.out.println();
			DATABASE.salvarEstado(gerente.getRepMotor());
			DATABASE.salvarEstado(repSolicitante);
			IRepositorio b = DATABASE.lerBaseMotorista();
			for(Object motor: b.getLista()){
				try{
				if(motor==null) break;
				((Motorista)motor).historico();
			 }catch(Exception e){
				 System.out.println(e.getMessage());
			 }
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
