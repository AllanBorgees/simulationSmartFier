package br.com.restfulSmartFier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restfulSmartFier.factory.ConexaoFactory;
import br.com.restfulSmartFier.factory.Mqtt;
import br.com.restfulSmartFier.model.Dados;
import br.com.restfulSmartFier.model.Estacao;
import br.com.restfulSmartFier.model.Funcionario;
import br.com.restfulSmartFier.model.Sensor;

public class EstacaoDAO {

	private static EstacaoDAO instancia = new EstacaoDAO();

	Mqtt mqtt = Mqtt.getIntancia();
	
	private EstacaoDAO() {
	}

	public static EstacaoDAO getInstancia() {
		return instancia;
	}

	FuncionarioDAO daoFunc = FuncionarioDAO.getInstancia();
	SensorDAO daoSensor = SensorDAO.getInstancia();

	/**
	 * 
	 * @return todas as estacoes sem nenhum vínculo
	 */
	public ArrayList<Estacao> getEstacoesDAO() {
		ArrayList<Estacao> e = new ArrayList<Estacao>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			// comando.setLong(1, u.getId());

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Estacao estacao = new Estacao();
				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
//				if(mqtt.isOnline(estacao.getEstacao_id())){
//					estacao.setStatus("online");
//				}else{
//					estacao.setStatus("offline");
//				}
//				
				e.add(estacao);

				
				
				
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		System.out.println("acabou o metodo");
		return e;
	}

	/**
	 * 
	 * @return todas as estacoes vinculadas com seus funcionarios.
	 */
	public Estacao getEstacaoFuncionarioSensoresDAO(String estacaoId) {
			Estacao estacao =new Estacao();
			Funcionario f = new Funcionario();
			ArrayList<Sensor> sensores = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, estacaoId);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
				f= daoFunc.getFuncionarioEstacaoDAO(estacao
						.getEstacao_id());
				estacao.setFuncionario(f);
				sensores = daoSensor.getSensoresIdEstacao(estacao
						.getEstacao_id());
				estacao.setSensores(sensores);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		 System.out.println(estacao);
		return estacao;
	}

	/**
	 * 
	 * @return todas as estacoes com sensores e dados vinculados
	 */
	public ArrayList<Estacao> getEstacaoSensoresDadosDAO() {

		ArrayList<Estacao> estacoes = new ArrayList<Estacao>();
		ArrayList<Sensor> sensores = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			System.out.println(sql.toString());
			// comando.setLong(1, u.getId());

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Estacao estacao = new Estacao();
				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
				sensores = daoSensor.getSensoresIdDadosEstacao(estacao
						.getEstacao_id());

				estacao.setSensores(sensores);
				estacoes.add(estacao);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		System.out.println(estacoes);
		return estacoes;
	}

	/**
	 * 
	 * @param estacaoId
	 *            utilizado para selecionar a estacao que vc quer.
	 * @return retorna a estacao vinculada com seus sensores e seus dados
	 *         através de seu ID
	 */
	public Estacao getEstacaoSensoresDadosByIdDAO(String estacaoId) {
		Estacao estacao = new Estacao();
		ArrayList<Sensor> sensores = null;

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, estacaoId);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
				sensores = daoSensor.getSensoresIdDadosEstacao(estacao
						.getEstacao_id());
				estacao.setSensores(sensores);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return estacao;
	}

	/**
	 * 
	 * @param estacaoId
	 * @return Lista a estacao com todos os atributos vinculados
	 */
	public Estacao getEstacaoFuncionariosSensoresDadosByIdDAO(String estacaoId) {
		Estacao estacao = new Estacao();
		ArrayList<Sensor> sensores = null;
		Funcionario funcionario = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, estacaoId);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
				funcionario = daoFunc.getFuncionarioEstacaoDAO(estacao
						.getEstacao_id());
				estacao.setFuncionario(funcionario);
				sensores = daoSensor.getSensoresIdEstacao(estacao
						.getEstacao_id());
				estacao.setSensores(sensores);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		System.out.println(estacao);
		return estacao;
	}

	public Estacao getEstacaoFuncionariosSensoresMediaDadosByIdDAO(String estacaoId) {
		Estacao estacao = new Estacao();
		ArrayList<Sensor> sensores = null;
		Funcionario funcionario = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT estacao_id, nome_estacao, ip, modelo, descricao, endereco ");
		sql.append("FROM estacao ");
		sql.append("where estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, estacaoId);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				estacao.setEstacao_id(resultado.getString("estacao_id"));
				estacao.setNome_estacao(resultado.getString("nome_estacao"));
				estacao.setIp(resultado.getString("ip"));
				estacao.setModelo(resultado.getString("modelo"));
				estacao.setDescricao(resultado.getString("descricao"));
				estacao.setEndereco(resultado.getString("endereco"));
				funcionario = daoFunc.getFuncionarioEstacaoDAO(estacao
						.getEstacao_id());
				estacao.setFuncionario(funcionario);
				sensores = daoSensor.getSensoresMediaIdEstacao(estacao
						.getEstacao_id());
				estacao.setSensores(sensores);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		System.out.println(estacao);
		return estacao;
	}

	
	public static void main(String[] args) {
		for(Estacao e : getInstancia().getEstacoesDAO()){
			System.out.println("----------------------------");
			System.out.println(e.getEstacao_id());
			System.out.println(e.getStatus());
		}
	}
}
