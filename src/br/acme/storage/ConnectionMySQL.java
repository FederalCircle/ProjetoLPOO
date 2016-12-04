package br.acme.storage;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionMySQL {
	
	private static String server= "localhost";
	private static String name	= "PLPOO";
	private static String url	= "jdbc:mysql://" + server + "/" + name;
	private static String user	= "root";
	private static String pass	= "";
	private static Boolean status = false;

	// Getters and Setters
	public static String getServer() {
		return server;
	}
	public static void setServer(String server) {
		ConnectionMySQL.server = server;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		ConnectionMySQL.name = name;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		ConnectionMySQL.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		ConnectionMySQL.user = user;
	}
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		ConnectionMySQL.pass = pass;
	}
	public static Boolean getStatus() {
		return status;
	}
	// END GnS
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";                        
			Class.forName(driverName);
			
			// Configurando conexão
			connection = DriverManager.getConnection(url, user, pass);
			
			// Testando conexão
			if (connection != null) status = true;
			
			return connection;
		}catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		}catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
	
	public static boolean closeConnection(){
		try {
			ConnectionMySQL.getConnection().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static ArrayList<String> searchAll(String tables, String fields) throws SQLException{
		Connection conn = getConnection();
		String query = "SELECT "+fields+" FROM "+tables;
		PreparedStatement stmt= conn.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()){
			array.add(result.getString(fields));
		}
		conn.close(); stmt.close(); result.close();
		return array;
	}
	public static ArrayList<String> searchAll(String tables, String fields, String where) throws SQLException{
		Connection conn = getConnection();
		String query = "SELECT "+fields+" FROM "+tables+" WHERE "+where;
		PreparedStatement stmt= conn.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()){
			array.add(result.getString(fields));
		}
		conn.close(); stmt.close(); result.close();
		return array;
	}

}
