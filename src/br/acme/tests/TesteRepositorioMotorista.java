package br.acme.tests;

import br.acme.storage.*;
import br.acme.users.Motorista;

public class TesteRepositorioMotorista {

	public static void main(String[] args) {
		try{
			// Criando os Motoristas ----------------------------------------------------------------------------------------------------
			Motorista motJose = new Motorista("450.047.226-68", "Jose", "jose123", "jose@motor.com", "Masculino", true);
			Motorista motAna = new Motorista( "450.047.226-68", "Ana", "ana123", "ana@motor.com", "Feminino", true);
			Motorista motMaria = new Motorista( "450.047.226-68", "Maria", "maria123", "maria@motor.com", "Feminino", true);
			
			// Criando o reposit�rio ----------------------------------------------------------------------------------------------------
			IRepositorio<Motorista> repositorio = new RepositorioMotorista();
			
			// Adicionando os Motoristas ao repositorio ----------------------------------------------------------------------------------------------------
			try{
				repositorio.adicionar (motJose);
				repositorio.adicionar(motAna);
				repositorio.adicionar(motMaria);
				repositorio.adicionar(motAna);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("ID\t\tNome\t\tEmail");
			for(Motorista user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			
			// Removendo os Motoristas do repositorio ----------------------------------------------------------------------------------------------------
			try{
				repositorio.remover(2); // Motorista existe
				repositorio.remover(5); // Motorista n�o existe
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			for(Motorista user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			
			// Alterando Motoristas do repositorio ----------------------------------------------------------------------------------------------------
			try{
				repositorio.alterar(9, motAna);// Motorista n�o existe
				repositorio.alterar(3, motAna);// Motorista existe
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			for(Motorista user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			
			// Buscando um Motorista ----------------------------------------------------------------------------------------------------
			try{System.out.println("O Motorista #1 �: "+repositorio.buscar(1).getNome()+"("+repositorio.buscar(1).getEmail()+")\n");
			
			// Retornando a lista de Motoristas ----------------------------------------------------------------------------------------------------
			Motorista[] lista = repositorio.buscarTodos();
			System.out.println("ID\t\tNome\t\tEmail");
			for(Motorista user: lista){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
	
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
