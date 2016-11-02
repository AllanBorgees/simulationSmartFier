package br.com.restfulSmartFier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restfulSmartFier.factory.ConexaoFactory;
import br.com.restfulSmartFier.model.Dados;
import br.com.restfulSmartFier.model.Estacao;
import br.com.restfulSmartFier.model.Sensor;

public class SensorDAO {

	private static SensorDAO instancia = new SensorDAO();

	private SensorDAO() {
	}

	public static SensorDAO getInstancia() {
		return instancia;
	}
	
	private DadoDAO daoDado = DadoDAO.getInstancia();

	// ok pegando
	public ArrayList<Sensor> getSensoresDAO() {
		ArrayList<Sensor> sensores = new ArrayList<Sensor>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			// comando.setLong(1, u.getId());

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				sensores.add(sensor);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return sensores;
	}

	public ArrayList<Sensor> getSensoresIdDadosEstacao(String idEstacao) {
		ArrayList<Sensor> sensores = new ArrayList<Sensor>();
		ArrayList<Dados> dados = null;

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idEstacao);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				dados = daoDado.getDadosIdSensores(sensor.getSensor_id());
				sensor.setDados(dados);
				sensores.add(sensor);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		System.out.println(sensores);

		return sensores;
	}
	public ArrayList<Sensor> getSensoresIdEstacao(String idEstacao) {
		ArrayList<Sensor> sensores = new ArrayList<Sensor>();
		ArrayList<Dados> dados = null;

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idEstacao);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				sensores.add(sensor);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return sensores;
	}

	public ArrayList<Sensor> getSensoresMediaIdEstacao(String idEstacao) {
		ArrayList<Sensor> sensores = new ArrayList<Sensor>();
		ArrayList<Dados> dados = null;

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idEstacao);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				dados = daoDado.getMediaDadosIdSensores(sensor.getSensor_id());
				sensor.setDados(dados);
				sensores.add(sensor);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		System.out.println(sensores);

		return sensores;
	}
	
	
	
	public ArrayList<Sensor> getSensorDados(){
		ArrayList<Sensor> sensores= new ArrayList<Sensor>();
		ArrayList<Dados> dados = null;
		
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");

		
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			System.out.println(sql.toString());
			// comando.setLong(1, u.getId());

			ResultSet resultado = comando.executeQuery();
			
			while (resultado.next()) {
				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				
				dados = daoDado.getDadosIdSensores(sensor.getSensor_id());
				sensor.setDados(dados);
				
				sensores.add(sensor);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		System.out.println(dados);
		return sensores;
	}
	
	public ArrayList<Sensor> getSensorIdDados(String idEstacao){
		ArrayList<Sensor> sensores= new ArrayList<Sensor>();
		ArrayList<Dados> dados = null;
		DadoDAO daoDado = DadoDAO.getInstancia();
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT sensor_id, modelo, grandeza, inteiro ");
		sql.append("FROM sensor ");
		sql.append("where estacao_id = ? ");

		
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			System.out.println(sql.toString());
			 comando.setString(1, idEstacao);

			ResultSet resultado = comando.executeQuery();
			
			while (resultado.next()) {
				Sensor sensor = new Sensor();
				sensor.setSensor_id(resultado.getString("sensor_id"));
				sensor.setModelo((resultado.getString("modelo")));
				sensor.setGrandeza((resultado.getString("grandeza")));
				sensor.setInteiro((resultado.getString("inteiro")));
				
				dados = daoDado.getDadosIdSensores(sensor.getSensor_id());
				sensor.setDados(dados);
				
				sensores.add(sensor);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		System.out.println(dados);
		return sensores;
	}

	
	public static void main(String[] args) {

//		getInstancia().getSensoresIdEstacao("estacao000");
		// for(Sensor s :getInstancia().getSensoresDAO()){
		// System.out.println(s.getModelo());
		// System.out.println(s.getSensor_id());
		// System.out.println("###############");
		// }
	}

}
