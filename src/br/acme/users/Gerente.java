package br.acme.users;
import br.acme.exception.RepositorioException;
import br.acme.storage.*;
import br.acme.exception.*;

@SuppressWarnings("serial")
public class Gerente extends Usuario {
	// Atributos ----------------------------------------------------------------------------------------------------
		private IRepositorio<Motorista> repMotor = new RepositorioMotorista();
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Gerente(String cpf, String nome, String senha, String email, String sexo) throws UsersExceptions{
		// Construtor da superClasse
		super(cpf,nome,senha,email,sexo);
	}

	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public IRepositorio getRepMotor(){
		return repMotor;
	}

	// Métodos ----------------------------------------------------------------------------------------------------
	public void cadastrarMotorista(Motorista newbie){
		try{repMotor.adicionar(newbie);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerMotorista(long id)throws RepositorioException{
		repMotor.remover(id);
		
	}
	
	public void listarMotoristas() throws RepositorioException{
		System.out.println("Nome\tEmail");
		for(Object motor : repMotor.buscarTodos()){
			if(motor==null) break;
			System.out.println(((Motorista) motor).getNome()+"\t"+((Motorista) motor).getEmail());
		}
		System.out.println();
	}
	
	public void listarClientes(IRepositorio<Solicitante> lista )throws RepositorioException{
		System.out.println("Nome\tEmail");
		for(Solicitante solicitante : lista.buscarTodos()){
			if(solicitante==null) break;
			System.out.println(solicitante.getNome()+"\t"+solicitante.getEmail());
		}
		System.out.println();
	}
	public String toString(){
		return super.toString();
	}
	
}
