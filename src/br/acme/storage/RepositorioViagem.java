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

	// M�todos ----------------------------------------------------------------------------------------------------
	public void adicionar(Object novoViagem) throws RepositorioException{
		/* 
		 * Para cada elemento n�o nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o la�o;
		 * 		> Se for diferente, segue para o pr�ximo elementoe e aumenta o �ndice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espa�oe quebra o la�o;
		 */
		int i=0;// �ndice do elemento no Array
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
		 * Caso qualquer elemento nulo seja encontrado, o la�o � encerrado;
		 * Se o elemento com o ID especificado seja encontrado a posi��o dele � igualada � null;
		 * Caso o elemento tenha sido removido do vetor:
		 * 	 > Se o �ndice for a �ltima posi��o, o espa�o se torna null;
		 *   > Se n�o, o espa�o atual � igualado ao pr�ximo;
		 */
		boolean removido = false; // Varia de acordo com o sucesso do m�todo
		int i=0;
		for(Viagem elemento: listaViagem){
			if(listaViagem[0]==null)throw new RepositorioException("O reposit�rio est� vazio.");
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se �ndice for a �ltima posi��o do vetor, � igualada � null, se n�o, ao pr�ximo elemento
				listaViagem[i]=(i==listaViagem.length-1)?null:listaViagem[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Viagem removido com sucesso.");
		}
		else
			throw new RepositorioException("Viagem n�o encontrado.");
	}
	
	public void alterar(long id, Object novoViagem) throws RepositorioException{
		boolean alterado = false; // Varia de acordo com o sucesso do m�todo
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
			throw new RepositorioException("Viagem n�o encontrada.");
	}
	
	public Viagem buscar(long id) throws RepositorioException{
		if(listaViagem[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Viagem Viagem : listaViagem){
			if(Viagem==null)break;
			if(Viagem.getId() == id){
				return Viagem;
			}
		}
		throw new RepositorioException("Viagem n�o encontrado.");
	}
	
	public Viagem[] buscarTodos() throws RepositorioException{
		if(listaViagem[0]==null){
			throw new RepositorioException("Repositorio vazio");
		}
		return this.getLista();
	}
}
