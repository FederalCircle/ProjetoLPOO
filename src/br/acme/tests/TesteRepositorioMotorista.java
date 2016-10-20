package br.acme.tests;

import java.util.ArrayList;

import br.acme.storage.RepositorioMotorista;
import br.acme.users.Motorista;

public class TesteRepositorioMotorista {

	public static void main(String[] args) {
		
		// Criando os Motoristas ----------------------------------------------------------------------------------------------------
		Motorista motJose = new Motorista("333.333.333-33", "Jose", "jose123", "jose@motor.com", "Masculino", true);
		Motorista motAna = new Motorista( "444.444.444-44", "Ana", "ana123", "ana@motor.com", "Feminino", true);
		Motorista motMaria = new Motorista( "555.555.555-55", "Maria", "maria123", "maria@motor.com", "Feminino", true);
		
		// Criando o repositório ----------------------------------------------------------------------------------------------------
		RepositorioMotorista repositorio = new RepositorioMotorista();
		
		// Adicionando os Motoristas ao repositorio ----------------------------------------------------------------------------------------------------
		repositorio.adicionar(motJose);
		repositorio.adicionar(motAna);
		repositorio.adicionar(motMaria);
		
		System.out.println("ID\t\tNome\t\tEmail");
		for(Motorista user: repositorio.getListaMotorista()){
			System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
		}
		System.out.println();
		
		// Removendo os Motoristas do repositorio ----------------------------------------------------------------------------------------------------
		repositorio.remover(2); // Motorista existe
		repositorio.remover(5); // Motorista não existe
		
		System.out.println("ID\t\tNome\t\tEmail");
		for(Motorista user: repositorio.getListaMotorista()){
			System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
		}
		System.out.println();
		
		// Alterando Motoristas do repositorio ----------------------------------------------------------------------------------------------------
		repositorio.alterar(9, motAna);// Motorista não existe
		repositorio.alterar(6, motAna);// Motorista existe
		
		System.out.println("ID\t\tNome\t\tEmail");
		for(Motorista user: repositorio.getListaMotorista()){
			System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
		}
		System.out.println();
		
		// Buscando um Motorista ----------------------------------------------------------------------------------------------------
		System.out.println("O Motorista #5 é: "+repositorio.buscar(5).getNome()+"("+repositorio.buscar(5).getEmail()+")\n");
		
		// Retornando a lista de Motoristas ----------------------------------------------------------------------------------------------------
		ArrayList<Motorista> lista = repositorio.buscarTodos();
		
		System.out.println("ID\t\tNome\t\tEmail");
		for(Motorista user: lista){
			System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
		}
		System.out.println();

	}

}
