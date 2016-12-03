package br.acme.tests;

import java.util.Date;


import br.acme.users.Solicitante;
import br.acme.storage.*;

public class TesteRepositorioSolicitante {

	public static void main(String[] args) {
		try{
			Date dataNascimento = new Date();
			// Criando os solicitantes ----------------------------------------------------------------------------------------------------
			Solicitante userPaula = new Solicitante("533.357.142-29", "paula@user.com", "123", "Paula", "Feminino", dataNascimento, 99112233);
			Solicitante userPedro = new Solicitante("641.480.568-85", "pedro@user.com", "abc", "Pedro", "Masculino", dataNascimento, 99887755);
			Solicitante userAndre = new Solicitante("553.754.276-56", "andre@user.com", "321", "André", "Masculino", dataNascimento, 99332211);
			
			// Criando o repositório ----------------------------------------------------------------------------------------------------
			IRepositorio<Solicitante> repositorio = new RepositorioSolicitante();
			
			// Adicionando os solicitantes ao repositorio ----------------------------------------------------------------------------------------------------
			try{
			repositorio.adicionar(userPaula);
			repositorio.adicionar(userPedro);
			repositorio.adicionar(userAndre);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			for(Solicitante user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			try{
			// Removendo os solicitantes do repositorio ----------------------------------------------------------------------------------------------------
			repositorio.remover(2); // Solicitante existe
			repositorio.remover(5); // Solicitante não existe
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			for(Solicitante user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			try{
			// Alterando solicitantes do repositorio ----------------------------------------------------------------------------------------------------
			repositorio.alterar(5, userPedro);// Solicitante não existe
			repositorio.alterar(3, userPedro);// Solicitante existe
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			for(Solicitante user: repositorio.getLista()){
				if(user==null)break;
				System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
			}
			System.out.println();
			try{
				// Buscando um solicitante ----------------------------------------------------------------------------------------------------
				System.out.println("O solicitante #2 é: "+repositorio.buscar(2).getNome()+"("+repositorio.buscar(2).getEmail()+")\n");
				
				// Retornando a lista de solicitantes ----------------------------------------------------------------------------------------------------
				Solicitante[] lista = repositorio.buscarTodos();
				
				for(Solicitante user: lista){
					if(user==null)break;
					System.out.println("#"+user.getId()+"\t\t"+user.getNome()+"\t\t"+user.getEmail());
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("ID\t\tNome\t\tEmail");
			
			System.out.println();
			System.out.println(userPaula.toString());	
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
