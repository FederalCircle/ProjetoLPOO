package br.acme.storage;

import br.acme.exception.RepositorioException;
import br.acme.users.Motorista;
public interface IRepositorioMotorista {
		public Motorista[] getListaMotorista();
		public void setListaMotorista(Motorista[] listaMotorista);
		public int getId();
		public void setId(int id);
		public void adicionar(Motorista motorista)throws RepositorioException;
		public void remover(long id)throws RepositorioException;
		public void alterar(long id,Motorista novomotorista)throws RepositorioException;
		public Motorista buscar(long id)throws RepositorioException;
		public Motorista[] buscarTodos()throws RepositorioException;
	
}
