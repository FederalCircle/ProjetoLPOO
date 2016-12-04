package br.acme.storage;

import java.sql.Connection;

import br.acme.users.Solicitante;

public class DB_Solicitante extends ConnectionMySQL {
	public static void insert(Solicitante user){
		Connection con = getConnection();
		String query = "INSERT INTO solicitante (cpf, email, senha, nome, sexo, dataNasc)";
	}
}
