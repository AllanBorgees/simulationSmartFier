package br.com.restfulSmartFier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.restfulSmartFier.factory.ConexaoFactory;
import br.com.restfulSmartFier.model.Dados;

public class DadoDAO {

	private static DadoDAO instancia = new DadoDAO();

	private DadoDAO() {
	}

	public static DadoDAO getInstancia() {
		return instancia;
	}

	
	
	
	
	
	
	
	public ArrayList<Dados> getDadosIdSensores(String idSensor) {
		ArrayList<Dados> dados = new ArrayList<Dados>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT valor, _dtepoch ");
		sql.append("FROM dados ");
		sql.append("where sensor_id = ? ");

//		 sql.append("SELECT ROUND(AVG(valor),2) , substr(_dtiso, 1, 10) ");
//		 sql.append("FROM dados where sensor_id= ? ");
//		 sql.append("group by substr(_dtiso, 1, 10)");
		// and _dtepoch between '1476431848' and '1476435448'
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idSensor);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Dados dado = new Dados();
				dado.setValor(resultado.getString("valor"));
//				dado.set_dtepoch((resultado.getString("_dtepoch")));
				dado.set_dtepoch((resultado.getString("_dtepoch")));
				dados.add(dado);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}

//		System.out.println(dados);

		return dados;
	}

	public ArrayList<Dados> getDadosIdSensoresData(String idSensor, String data1, String data2) {
		ArrayList<Dados> dados = new ArrayList<Dados>();

		StringBuilder sql = new StringBuilder();

//		sql.append("SELECT valor, _dtepoch ");
//		sql.append("FROM dados ");
//		sql.append("where sensor_id = ? ");

		 sql.append("SELECT valor , _dtepoch ");
		 sql.append("FROM dados where sensor_id= ? ");
		 sql.append("and _dtepoch >= ? and _dtepoch <= ? ");
		// 
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idSensor);
			comando.setString(2, data1);
			comando.setString(3, data2);
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Dados dado = new Dados();
				dado.setValor(resultado.getString("valor"));
				dado.set_dtepoch((resultado.getString("_dtepoch")));
				dados.add(dado);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}

//		System.out.println(dados);
		return dados;
	}
	
	
	
	
	public static void main(String[] args) {
		ArrayList<Dados> dados = new DadoDAO().getDadosIdSensoresData("sensor006","1477045800","1477050000");
//		http://localhost:8080/simulationSmartFier/rest/dado/getdadossensor/sensor006/1477045800/1477050000		
		for(Dados d : dados){
			System.out.println("---------------");
			System.out.println(d);
			
		}
	}
	public ArrayList<Dados> getMediaDadosIdSensores(String idSensor) {
		ArrayList<Dados> dados = new ArrayList<Dados>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ROUND(AVG(valor),2) , substr(_dtiso, 1, 10) ");
		sql.append("FROM dados ");
		sql.append("where sensor_id = ? ");
		sql.append("group by substr(_dtiso, 1, 10) ");
 		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idSensor);

			ResultSet resultado = comando.executeQuery();
			float valor = 0;
			int x = 1;
			while (resultado.next()) {

				Dados dado = new Dados();
				
				dado.setValor(resultado.getString("ROUND(AVG(valor),2)"));
				dado.set_dtiso((resultado.getString("substr(_dtiso, 1, 10)")));
				
				dados.add(dado);

				
			}
		} catch (Exception es) {
			es.printStackTrace();
		}

		System.out.println(dados);

		return dados;
	}

	
	

}
