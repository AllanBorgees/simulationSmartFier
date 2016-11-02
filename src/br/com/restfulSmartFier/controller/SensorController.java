package br.com.restfulSmartFier.controller;

import java.util.ArrayList;

import br.com.restfulSmartFier.dao.SensorDAO;
import br.com.restfulSmartFier.model.Estacao;
import br.com.restfulSmartFier.model.Sensor;

public class SensorController {

	private static SensorController sensorCon = new SensorController();

	private SensorController() {
	}

	public static SensorController getInstancia() {
		return sensorCon;
	}

	SensorDAO dao = SensorDAO.getInstancia();

	// ok pegando
	public ArrayList<Sensor> getSensoresController() {
		return dao.getSensoresDAO();
	}

	// ok pegando
	public ArrayList<Sensor> getSensorDados() {

		return dao.getSensorDados();

	}

}
