package br.com.restfulSmartFier.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restfulSmartFier.controller.SensorController;
import br.com.restfulSmartFier.model.Sensor;

@Path("/sensor")
public class SensorResource {

	SensorController sensorController = SensorController.getInstancia();

	@GET
	@Path("/getsensores")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sensor> getSensores() {
		return sensorController.getSensoresController();

	}

	@GET
	@Path("/getsensoresdados")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sensor> getEstacaoSensores() {
		return sensorController.getSensorDados();

	}

}
