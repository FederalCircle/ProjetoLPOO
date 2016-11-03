package br.acme.storage;
import br.acme.exception.RepositorioException;
import br.acme.location.*;
public interface IRepositorioViagem {
		public void adicionar(Viagem viagem)throws RepositorioException;
		public void remover(long id) throws RepositorioException;
		public Viagem buscar(long id) throws RepositorioException;
		public Viagem[] buscarTodos() throws RepositorioException;
}
