package br.com.restfulSmartFier.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
//	public static final String USUARIO="smartfier";
//	public static final String SENHA="smartfier";
//	public static final String URL ="jdbc:mysql://nachos.ftp.sh:3306/smartfier";
	
	public static final String USUARIO="root";
	public static final String SENHA="WEb@master007";
	public static final String URL ="jdbc:mysql://localhost:3306/smartfier";
	
	
	
	//"jdbc:mysql://localhost:3306/smartfierb";

	public static Connection conectar()throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try{
			Connection conexao = ConexaoFactory.conectar();	
			System.out.println("conexao realizada com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Nao foi possivel realizar a conexao");
		}
		
		
	}
}
