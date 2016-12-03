package br.acme.storage;

import br.acme.exception.RepositorioException;
import br.acme.users.Solicitante;

public interface IRepositorio <T> {
	public T[] getLista();
	public void setLista(T[] t);
	public void adicionar(T t)throws RepositorioException;
	public void remover(long t)throws RepositorioException;
	public void alterar(long t, T novo)throws RepositorioException;
	public T buscar(long t)throws RepositorioException;
	public T[] buscarTodos()throws RepositorioException;
	public int getId();
}
