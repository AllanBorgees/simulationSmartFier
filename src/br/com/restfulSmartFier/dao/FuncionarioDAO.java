package br.com.restfulSmartFier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restfulSmartFier.factory.ConexaoFactory;
import br.com.restfulSmartFier.model.Funcionario;

public class FuncionarioDAO {

	private static FuncionarioDAO instancia = new FuncionarioDAO();

	private FuncionarioDAO() {
	}

	public static FuncionarioDAO getInstancia() {
		return instancia;
	}

	// funcionando OK
	public ArrayList<Funcionario> getFuncionariosDAO() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT login, senha, nome, email, tipo, funcionario_id, CPF ");
		sql.append("FROM usuario_funcionario");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			// comando.setLong(1, u.getId());

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Funcionario funcionario = new Funcionario();
				funcionario.setLogin((resultado.getString("login")));
				funcionario.setSenha((resultado.getString("senha")));
				funcionario.setNome((resultado.getString("nome")));
				funcionario.setEmail((resultado.getString("email")));
				funcionario.setFuncionario_id((resultado
						.getInt("funcionario_id")));
				funcionario.setCpf((resultado.getString("CPF")));

				funcionarios.add(funcionario);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}

		// for(Funcionario f : funcionarios){
		// System.out.println(f.getLogin());
		// }

		return funcionarios;
	}

	public Funcionario getFuncionarioEstacaoDAO(String idEstacao) {

		Funcionario funcionario = new Funcionario();

		StringBuilder sql = new StringBuilder();

		sql.append("select f.nome, f.email , f.CPF, f.tipo, f.login, f.senha, f.funcionario_id ");
		sql.append("from usuario_funcionario f inner join estacao e ");
		sql.append("where e.funcionario_id = f.funcionario_id and e.estacao_id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			comando.setString(1, idEstacao);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {

				funcionario.setLogin((resultado.getString("login")));
				funcionario.setSenha((resultado.getString("senha")));
				funcionario.setNome((resultado.getString("nome")));
				funcionario.setEmail((resultado.getString("email")));
				funcionario.setFuncionario_id((resultado
						.getInt("funcionario_id")));
				funcionario.setCpf((resultado.getString("CPF")));
				funcionario.setTipo(resultado.getString("tipo"));

			}
		} catch (Exception es) {
			es.printStackTrace();
		}

		return funcionario;

	}
}
