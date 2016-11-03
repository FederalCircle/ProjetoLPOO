package br.acme.storage;
import br.acme.location.Viagem;
import br.acme.exception.*;
public class RepositorioViagem implements IRepositorioViagem{
	// Atributos ----------------------------------------------------------------------------------------------------
	private Viagem[] listaViagem = new Viagem[10];
	
	// Construtor Padrão
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Viagem[] getListaViagem() {
		return listaViagem;
	}

	public void setListaViagem(Viagem[] listaViagem) {
		this.listaViagem = listaViagem;
	}
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Viagem novoViagem)throws RepositorioException{
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
				if(elemento.getId()==novoViagem.getId())
					throw new RepositorioException("JA há uma viagem com essa ID");
				else
					i++;
			}
			else{
				listaViagem[i]=novoViagem;
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
		if(listaViagem[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Viagem elemento: listaViagem){
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
			throw new RepositorioException("A viagem nao foi encontrada");
	}

	public Viagem buscar(long id)throws RepositorioException{
		if(listaViagem[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Viagem viagem : listaViagem){
			if(viagem==null)break;
			if(viagem.getId() == id){
				return viagem;
			}
		}
		throw new RepositorioException("A viagem nao foi emcontrada");
	}
	
	public Viagem[] buscarTodos()throws RepositorioException{
		if(listaViagem[0]==null){
			throw new RepositorioException("o Repositorio esta Vazio");
		}
		return this.getListaViagem();
	}
}
