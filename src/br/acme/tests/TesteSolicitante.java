package br.acme.tests;
import br.acme.users.*;
import java.util.Date;

public class TesteSolicitante {
	
	public static void main(String[] args) {
		Date dataNascimento = new Date();
		
		// Criando um solicitante ----------------------------------------------------------------------------------------------------
		Solicitante userPaula = new Solicitante("111.111.111-11", "paula@user.com", "123", "Paula", "Feminino", dataNascimento, 912345678);
		
		// Exibindo as informações ----------------------------------------------------------------------------------------------------
		System.out.println("Informações do usuário..."
				+ "\nID: "+ userPaula.getId()
				+ "\nNome: "+ userPaula.getNome()
				+ "\nSenha: "+ userPaula.getSenha()
				+ "\nCPF: "+ userPaula.getCpf()
				+ "\nE-mail: "+ userPaula.getEmail()
				+ "\nCelular: "+ userPaula.getNumeroCelular()
				+ "\nSexo: "+ userPaula.getSexo()
				+ "\nData de nascimento: "+ userPaula.getDataNascimento());
		
		// Alterando as informações ----------------------------------------------------------------------------------------------------
		userPaula.setNome(userPaula.getNome()+" Fernandes", "123");
		userPaula.setSenha("abc", "123");
		userPaula.setCpf("222.222.222-22", "abc");
		userPaula.setEmail("paula_fernandes@user.com", "abc");
		userPaula.setNumeroCelular(988776655, "abc");
		userPaula.setSexo("Feminino^2", "123");//Senha Errada
		
		// Exibindo as informações ----------------------------------------------------------------------------------------------------
				System.out.println("\nInformações do usuário..."
						+ "\nID: "+ userPaula.getId()
						+ "\nNome: "+ userPaula.getNome()
						+ "\nSenha: "+ userPaula.getSenha()
						+ "\nCPF: "+ userPaula.getCpf()
						+ "\nE-mail: "+ userPaula.getEmail()
						+ "\nCelular: "+ userPaula.getNumeroCelular()
						+ "\nSexo: "+ userPaula.getSexo()
						+ "\nData de nascimento: "+ userPaula.getDataNascimento());
	}
}
