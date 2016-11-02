package br.com.restfulSmartFier.controller;

import java.util.ArrayList;

import br.com.restfulSmartFier.dao.FuncionarioDAO;
import br.com.restfulSmartFier.model.Funcionario;

public class FuncionarioController {

	private static FuncionarioController funcionarioCon = new FuncionarioController();

	private FuncionarioDAO dao = FuncionarioDAO.getInstancia();

	private FuncionarioController() {

	}

	public static FuncionarioController getInstancia() {
		return funcionarioCon;
	}

	public ArrayList<Funcionario> getFuncionariosController() {
		return dao.getFuncionariosDAO();
	}

}
