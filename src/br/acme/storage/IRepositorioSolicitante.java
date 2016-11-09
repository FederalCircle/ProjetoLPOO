package br.acme.storage;
import br.acme.exception.RepositorioException;
import br.acme.users.Solicitante;

public interface IRepositorioSolicitante{
	public Solicitante[] getListaSolicitante();
	public void setListaSolicitante(Solicitante[] listaSolicitante);
	public void adicionar(Solicitante solicitante)throws RepositorioException;
	public void remover(long id)throws RepositorioException;
	public void alterar(long id, Solicitante novosolicitante)throws RepositorioException;
	public Solicitante buscar(long id)throws RepositorioException;
	public Solicitante[] buscarTodos()throws RepositorioException;
}