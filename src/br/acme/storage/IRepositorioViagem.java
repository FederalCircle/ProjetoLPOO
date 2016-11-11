package br.acme.storage;
import br.acme.exception.RepositorioException;
import br.acme.location.Viagem;
public interface IRepositorioViagem {
		public Viagem[] getListaViagem();
		public void setListaViagem(Viagem[] listaViagem);
		public void adicionar(Viagem viagem)throws RepositorioException;
		public void remover(long id) throws RepositorioException;
		public Viagem buscar(long id) throws RepositorioException;
		public Viagem[] buscarTodos() throws RepositorioException;
		public int getId();
}
