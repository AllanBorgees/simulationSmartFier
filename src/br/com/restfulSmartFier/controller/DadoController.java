package br.com.restfulSmartFier.controller;

import java.util.ArrayList;

import br.com.restfulSmartFier.dao.DadoDAO;
import br.com.restfulSmartFier.model.Dados;

public class DadoController {
	private static DadoController dadoCon = new DadoController();

	private DadoController() {
		// TODO Auto-generated constructor stub
	}
	
	DadoDAO dao = DadoDAO.getInstancia();

	public static DadoController getInstancia() {
		return dadoCon;
	}
	
	public ArrayList<Dados> getDadoController(String sensorId) {
		return dao.getDadosIdSensores(sensorId);
		// return dao.getEstacaoSensoresDadosByIdDAO(estacaoId);
	}

	
}
