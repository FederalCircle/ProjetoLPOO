package br.acme.users;
import br.acme.storage.*;
import java.io.*;
import br.acme.exception.RepositorioException;
import br.acme.exception.UsersExceptions;
import br.acme.location.*;
import br.acme.users.Solicitante;
import java.util.Random;

@SuppressWarnings("serial")
public class Motorista extends Usuario implements Serializable {
	// Atributos ----------------------------------------------------------------------------------------------------
	private boolean disponivel;
	private IRepositorioViagem viagens = new RepositorioViagem();
	
	// Construtor ----------------------------------------------------------------------------------------------------
	public Motorista(String cpf, String nome, String senha, String email, String sexo, boolean disponivel) throws UsersExceptions {
		// Contrutor da superClasse
		super(cpf,nome,senha,email,sexo);
		this.disponivel = true;
	}
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public IRepositorioViagem getViagens() {
		return viagens;
	}

	public void setViagens(RepositorioViagem viagens) {
		this.viagens = viagens;
	}

	// Métodos ----------------------------------------------------------------------------------------------------
	public Viagem responderPedido(Solicitante cliente, Lugar inicio, Lugar fim, String formaPagamento)throws RepositorioException{
		disponivel = false;
		Random preco = new Random();
		Viagem travel = new Viagem(cliente, this, inicio, fim, preco.nextInt(101)+50, formaPagamento);
		viagens.adicionar(travel);
		System.out.println(cliente.getNome()+", motorista "+this.getNome()+" aceitou sua viagem");
		return travel;
	}
	
	public void historico()throws RepositorioException{
		System.out.println("Histórico de viagens ("+this.getNome()+")");
		for(Viagem travel: viagens.buscarTodos()){
			if(travel==null) break;
			System.out.println("ID: "+travel.getId());
			System.out.println("Origem: "+travel.getOrigem().getEndereco());
			System.out.println("Destino: "+travel.getDestino().getEndereco());
			System.out.println("Cliente: "+travel.getCliente().getNome());
			System.out.println("Preço: "+travel.getValorViagem());
		}
		System.out.println();
	}
	
	public String toString(){
		return super.toString()+"Disponível: "+this.disponivel+";";
	}
}
