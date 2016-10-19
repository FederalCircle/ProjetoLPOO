package br.acme.storage;

import java.util.ArrayList;

import br.acme.users.Motorista;

public class RepositorioMotorista {
	// Atributos ----------------------------------------------------------------------------------------------------
	private ArrayList<Motorista> listaMotorista = new ArrayList<Motorista>();
	
	// Construtor Padrão
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public ArrayList<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(ArrayList<Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	
	// Métodos ----------------------------------------------------------------------------------------------------
	public void adicionar(Motorista novoMotorista){
		listaMotorista.add(novoMotorista);
	}
	
	public void remover(long id){
		boolean removido = false; // Variável booleana que varia de acordo com o sucesso do método
		for(Motorista element: listaMotorista){
			if(element.getId() == id){
				listaMotorista.remove(element);
				removido=true;
			}
		}
		if(removido)
			System.out.println("Motorista removido com sucesso.");
		else
			System.out.println("Motorista não encontrado.");
	}
	
	public void alterar(long id, Motorista novoMotorista){
		boolean alterado = false; //Variável booleana que varia de acordo com o sucesso do método
		int i = 0; // Índice do elemento no ArrayList
		// Percorre o ArrayList alterando o índice até encontrar o elemento desejado
		for(Motorista element: listaMotorista){
			if(element.getId() == id){
				listaMotorista.set(i, novoMotorista);
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Motorista alterado com sucesso.");
		else
			System.out.println("Motorista não encontrado.");
	}
	
	public Motorista buscar(long id){
		for(Motorista element : listaMotorista){
			if(element.getId() == id){
				return element;
			}
		}
		return null;
	}
	
	public ArrayList<Motorista> buscarTodos(){
		return this.getListaMotorista();
	}
}
