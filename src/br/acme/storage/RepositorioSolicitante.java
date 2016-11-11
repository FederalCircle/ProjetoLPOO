package br.acme.storage;
import java.io.*;

import br.acme.exception.RepositorioException;
import br.acme.users.Solicitante;

public class RepositorioSolicitante implements IRepositorioSolicitante,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos ----------------------------------------------------------------------------------------------------
	private Solicitante[] listaSolicitante = new Solicitante[10];
	private int id;
	private static int idIncrement=0;
	
	public RepositorioSolicitante(){
		idIncrement++;
		this.setId(idIncrement);
	}
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Solicitante[] getListaSolicitante() {
		return listaSolicitante;
	}

	public void setListaSolicitante(Solicitante[] listaSolicitante) {
		this.listaSolicitante = listaSolicitante;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Solicitante novoSolicitante)throws RepositorioException{
		/* 
		 * Para cada elemento não nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o laço;
		 * 		> Se for diferente, segue para o próximo elementoe e aumenta o índice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espaçoe quebra o laço;
		 */
		int i=0;// Índice do elemento no Array
		for(Solicitante elemento: listaSolicitante){
			if(elemento!=null){
				if(elemento.getId()==novoSolicitante.getId())
					throw new RepositorioException("o ID ja esta em uso");				else
					i++;
			}
			else{
				listaSolicitante[i]=novoSolicitante;
				break;
			}
		}
	}
	
	public void remover(long id)throws RepositorioException{
		/*
		 * Caso qualquer elemento nulo seja encontrado, o laço é encerrado;
		 * Se o elemento com o ID especificado seja encontrado a posição dele é igualada à null;
		 * Caso o elemento tenha sido removido do vetor:
		 * 	 > Se o índice for a última posição, o espaço se torna null;
		 *   > Se não, o espaço atual é igualado ao próximo;
		 */
		boolean removido = false; // Varia de acordo com o sucesso do método
		int i=0;
		if(listaSolicitante[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Solicitante elemento: listaSolicitante){
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se índice for a última posição do vetor, é igualada à null, se não, ao próximo elemento
				listaSolicitante[i]=(i==listaSolicitante.length-1)?null:listaSolicitante[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Solicitante removido com sucesso.");
		}
		else
			throw new RepositorioException("o Solicitante nao encontrado");
	}
	
	public void alterar(long id, Solicitante novoSolicitante)throws RepositorioException{
		boolean alterado = false; // Varia de acordo com o sucesso do método
		int i=0;
		if(listaSolicitante[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Solicitante elemento: listaSolicitante){
			if(elemento==null)break;
			if(elemento.getId() == id){
				listaSolicitante[i]=novoSolicitante;
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Solicitante alterado com sucesso.");
		else
			throw new RepositorioException("Solicitante não encontrado.");
	}
	
	public Solicitante buscar(long id)throws RepositorioException{
		if(listaSolicitante[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Solicitante solicitante : listaSolicitante){
			if(solicitante==null)break;
			if(solicitante.getId() == id){
				return solicitante;
			}
		}
		throw new RepositorioException("o Solicitante nao foi encontrado");
	}
	
	public Solicitante[] buscarTodos()throws RepositorioException{
		if(listaSolicitante[0]==null){
			throw new RepositorioException("o Repositorio esta Vazio");
		}
		return this.getListaSolicitante();
	}
}