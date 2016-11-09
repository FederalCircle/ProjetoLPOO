package br.acme.storage;
import br.acme.users.Motorista;
import br.acme.exception.RepositorioException;
public class RepositorioMotorista implements IRepositorioMotorista {
	// Atributos ----------------------------------------------------------------------------------------------------
	private Motorista[] listaMotorista = new Motorista[10];
	
	// Construtor Padrão
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Motorista[] getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(Motorista[] listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Motorista novoMotorista) throws RepositorioException{
		/* 
		 * Para cada elemento não nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o laço;
		 * 		> Se for diferente, segue para o próximo elementoe e aumenta o índice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espaçoe quebra o laço;
		 */
		int i=0;// Índice do elemento no Array
		for(Motorista elemento: listaMotorista){
			if(elemento!=null){
				if(elemento.getId()==novoMotorista.getId())
					throw new RepositorioException("Ja existe um objeto com essa ID");
				else
					i++;
			}
			else{
				listaMotorista[i]=novoMotorista;
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
		for(Motorista elemento: listaMotorista){
			if(listaMotorista[0]==null)throw new RepositorioException("O repositório está vazio.");
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se índice for a última posição do vetor, é igualada à null, se não, ao próximo elemento
				listaMotorista[i]=(i==listaMotorista.length-1)?null:listaMotorista[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Motorista removido com sucesso.");
		}
		else
			throw new RepositorioException("Motorista não encontrado.");
	}
	
	public void alterar(long id, Motorista novoMotorista) throws RepositorioException{
		boolean alterado = false; // Varia de acordo com o sucesso do método
		int i=0;
		if(listaMotorista[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Motorista elemento: listaMotorista){
			if(elemento==null)break;
			if(elemento.getId() == id){
				listaMotorista[i]=novoMotorista;
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Motorista alterado com sucesso.");
		else
			throw new RepositorioException("Motorista não encontrado.");
	}
	
	public Motorista buscar(long id) throws RepositorioException{
		if(listaMotorista[0]==null)throw new RepositorioException("o Repositorio esta Vazio");
		for(Motorista motorista : listaMotorista){
			if(motorista==null)break;
			if(motorista.getId() == id){
				return motorista;
			}
		}
		throw new RepositorioException("Motorista não encontrado.");
	}
	
	public Motorista[] buscarTodos() throws RepositorioException{
		if(listaMotorista[0]==null){
			throw new RepositorioException("Repositorio vazio");
		}
		return this.getListaMotorista();
	}
}
