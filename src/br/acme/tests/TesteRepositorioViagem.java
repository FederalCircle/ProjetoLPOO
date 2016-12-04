package br.acme.tests;

import java.util.Date;

import br.acme.storage.*;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;
import br.acme.location.Lugar;
import br.acme.location.Viagem;

public class TesteRepositorioViagem {

	public static void main(String[] args) {
		Date dataNascimento = new Date();// necessário para Solicitante
		try{
/*Solicitantes, Motoristas e Viagens são necessários para Viagem*/
		// Criando os solicitantes
		Solicitante solPaula = new Solicitante("450.047.226-68", "paula@travel.com", "paula123", "Paula", "Feminino", dataNascimento, "99112233");
		Solicitante solPedro = new Solicitante("378.840.363-20", "pedro@travel.com", "pedro123", "Pedro", "Masculino", dataNascimento, "99887755");
		Solicitante solAndre = new Solicitante("575.580.722-12", "andre@travel.com", "andre123", "André", "Masculino", dataNascimento, "99332211");
		
		// Criando os motoristas
		Motorista motJose = new Motorista("013.288.455-08", "Jose", "jose123", "jose@motor.com", "Masculino", true);
		Motorista motAna = new Motorista("108.560.050-53", "Ana", "ana123", "ana@motor.com", "Feminino", true);
		Motorista motMaria = new Motorista("762.086.663-92", "Maria", "maria123", "maria@motor.com", "Feminino", true);
		
		//Criando os lugares
		Lugar inicio = new Lugar("Praça", "Rua Alpha, 256");
		Lugar fim = new Lugar("Mercado", "Rua Omega, 652");
		
		// Criando os Viagems ----------------------------------------------------------------------------------------------------

		Viagem  travel1 = new Viagem(solPaula, motAna, inicio, fim, 50, "Cartão");
		Viagem  travel2 = new Viagem( solPedro, motJose, inicio, fim, 55, "à Vista");
		Viagem  travel3 = new Viagem( solAndre, motMaria, inicio, fim, 60, "Cheque");
		
		// Criando o repositório ----------------------------------------------------------------------------------------------------
		IRepositorio<Viagem> repositorio = new RepositorioViagem();
		
		// Adicionando os Viagems ao repositorio ----------------------------------------------------------------------------------------------------
		repositorio.adicionar(travel1);
		repositorio.adicionar(travel2);
		repositorio.adicionar(travel3);
		
		System.out.println("ID\t\tOrigem\t\tDestino");
		for(Viagem travel: repositorio.getLista()){
			if(travel==null)break;
			System.out.println("#"+travel.getId()+"\t\t"+travel.getOrigem().getEndereco()+"\t\t"+travel.getDestino().getEndereco());
		}
		System.out.println();
		
		// Removendo os Viagems do repositorio ----------------------------------------------------------------------------------------------------
		repositorio.remover(2); // Viagem existe
		repositorio.remover(5); // Viagem não existe
		
		System.out.println("ID\t\tOrigem\t\tDestino");
		for(Viagem travel: repositorio.getLista()){
			if(travel==null)break;
			System.out.println("#"+travel.getId()+"\t\t"+travel.getOrigem().getEndereco()+"\t\t"+travel.getDestino().getEndereco());
		}
		System.out.println();
		
		// Buscando um Viagem ----------------------------------------------------------------------------------------------------
		System.out.println("O Viagem #3 foi de ("+repositorio.buscar(3).getOrigem().getEndereco()+") até ("+repositorio.buscar(3).getDestino().getEndereco()+")\n");
		
		// Retornando a lista de Viagems ----------------------------------------------------------------------------------------------------
		Viagem[] lista = repositorio.buscarTodos();
		
		System.out.println("ID\t\tOrigem\t\tDestino");
		for(Viagem travel: lista){
			if(travel==null)break;
			System.out.println("#"+travel.getId()+"\t\t"+travel.getOrigem().getEndereco()+"\t\t"+travel.getDestino().getEndereco());
		}
		System.out.println();
		System.out.println(travel1.toString());

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
