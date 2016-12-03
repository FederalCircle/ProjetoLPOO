package br.acme.storage;
import java.io.*;
import br.acme.location.*;
import br.acme.users.Usuario;
import br.acme.exception.RepositorioException;

public class RepositorioViagem implements IRepositorio,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos ----------------------------------------------------------------------------------------------------
	private Viagem[] listaViagem = new Viagem[10];
	private int id;
	private static int idIncrement=0;
	
	public RepositorioViagem(){
		idIncrement++;
		this.setId(idIncrement);
	}
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Viagem[] getLista() {
		return listaViagem;
	}

	public void setLista(Object[] listaViagem) {
		this.listaViagem = (Viagem[]) listaViagem;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Object novoViagem) throws RepositorioException{
		/* 
		 * Para cada elemento não nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o laço;
		 * 		> Se for diferente, segue para o próximo elementoe e aumenta o índice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espaçoe quebra o laço;
		 */
		int i=0;// Índice do elemento no Array
		for(Viagem elemento: listaViagem){
			if(elemento!=null){
				if(elemento.getId()==((Viagem)novoViagem).getId())
					throw new RepositorioException("Ja existe um objeto com essa ID");
				else
					i++;
			}
			else{
				listaViagem[i]=(Viagem)novoViagem;
				break;
			}
		}
	}
	
	public void remover(long id) throws RepositorioException{
		/*
		 * Caso qualquer elemento nulo seja encontrado, o laço é encerrado;
		 * Se o elemento com o ID especificado seja encontrado a posição dele é igualada à null;
		 * Caso o elemento tenha sido removido do vetor:
		 * 	 > Se o índice for a última posição, o espaço se torna null;
		 *   > Se não, o espaço atual é igualado ao próximo;
		 */
		boolean removido = false; // Varia de acordo com o sucesso do método
		int i=0;
		for(Viagem elemento: listaViagem){
			if(listaViagem[0]==null)throw new RepositorioException("O repositório está vazio.");
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se índice for a última posição do vetor, é igualada à null, se não, ao próximo elemento
				listaViagem[i]=(i==listaViagem.length-1)?null:listaViagem[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Viagem removido com sucesso.");
		}
		else
			throw new RepositorioException("Viagem não encontrado.");
	}
	
	public void alterar(long id, Object novoViagem) throws RepositorioException{
		boolean alterado = false; // Varia de acordo com o sucesso do método
		int i=0;
		if(listaViagem[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Viagem elemento: listaViagem){
			if(elemento==null)break;
			if(elemento.getId() == id){
				listaViagem[i]=(Viagem)novoViagem;
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Viagem alterado com sucesso.");
		else
			throw new RepositorioException("Viagem não encontrada.");
	}
	
	public Viagem buscar(long id) throws RepositorioException{
		if(listaViagem[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Viagem Viagem : listaViagem){
			if(Viagem==null)break;
			if(Viagem.getId() == id){
				return Viagem;
			}
		}
		throw new RepositorioException("Viagem não encontrado.");
	}
	
	public Viagem[] buscarTodos() throws RepositorioException{
		if(listaViagem[0]==null){
			throw new RepositorioException("Repositorio vazio");
		}
		return this.getLista();
	}
}
