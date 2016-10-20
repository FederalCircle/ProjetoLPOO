	package br.acme.storage;
import br.acme.users.Solicitante;
import java.util.ArrayList;

public class RepositorioSolicitante {
	// Atributos ----------------------------------------------------------------------------------------------------
	private ArrayList<Solicitante> listaSolicitante = new ArrayList<Solicitante>();

	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public ArrayList<Solicitante> getListaSolicitante() {
		return listaSolicitante;
	}

	public void setListaSolicitante(ArrayList<Solicitante> listaSolicitante) {
		this.listaSolicitante = listaSolicitante;
	}
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Solicitante novoSolicitante){
		listaSolicitante.add(novoSolicitante);
	}
	
	public void remover(long id){
		boolean removido = false; // Variável booleana que varia de acordo com o sucesso do método
		for(Solicitante user: listaSolicitante){
			if(user.getId() == id){
				listaSolicitante.remove(user);
				removido=true;
			}
		}
		if(removido)
			System.out.println("Solicitante removido com sucesso.");
		else
			System.out.println("Solicitante não encontrado.");
	}
	
	public void alterar(long id, Solicitante altUser){
		boolean alterado = false; //Variável booleana que varia de acordo com o sucesso do método
		int i = 0; // Índice do elemento no ArrayList
		// Percorre o ArrayList alterando o índice até encontrar o elemento desejado
		for(Solicitante user: listaSolicitante){
			if(user.getId() == id){
				listaSolicitante.set(i, altUser);
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Solicitante alterado com sucesso.");
		else
			System.out.println("Solicitante não encontrado.");
	}
	
	public Solicitante buscar(long id){
		for(Solicitante user : listaSolicitante){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<Solicitante> buscarTodos(){
		return this.getListaSolicitante();
	}
}
