package br.com.restfulSmartFier.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restfulSmartFier.controller.FuncionarioController;
import br.com.restfulSmartFier.model.Funcionario;

@Path("/funcionario")
public class FuncionarioResource {

FuncionarioController funcionarioController = FuncionarioController.getInstancia();
	
	@GET
	@Path("/getfuncionarios")
	//@Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Funcionario> getFuncionarios(){
		return funcionarioController.getFuncionariosController();
	}
	
}
