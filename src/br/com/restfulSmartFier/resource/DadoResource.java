package br.com.restfulSmartFier.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restfulSmartFier.controller.DadoController;
import br.com.restfulSmartFier.dao.DadoDAO;
import br.com.restfulSmartFier.model.Dados;


@Path("/dado")
public class DadoResource {

	DadoController dadoCon = DadoController.getInstancia();
	
	@GET
	@Path("/getdadossensor/{sensor_id}")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Dados> getDadosIdSensores(@PathParam("sensor_id") String sensor_id){
		return dadoCon.getDadoController(sensor_id);
	}
	DadoDAO d = DadoDAO.getInstancia();
	@GET
	@Path("/getdadossensor/id/{sensor_id}/{data1}/{data2}")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Dados> getDadosIdSensoresD(@PathParam("sensor_id") String sensor_id,
			@PathParam("data1") String data1,
			@PathParam("data2") String data2){
		return d.getDadosIdSensoresData(sensor_id, data1, data2);
	}

	public static void main(String[] args) {
		ArrayList<Dados> d = new DadoResource().getDadosIdSensores("sensor005");
		
		for(Dados da : d){
			System.out.println(da);
		}
		
		
	}
	
}
