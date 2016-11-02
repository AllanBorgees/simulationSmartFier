package br.com.restfulSmartFier.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restfulSmartFier.controller.EstacaoController;
import br.com.restfulSmartFier.model.Estacao;

@Path("/estacao")
public class EstacaoResource {

	EstacaoController estacaoController = EstacaoController.getInstancia();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendEmail(String EstacaoId) {
		estacaoController.enviarEmail(EstacaoId);
	}

	@GET
	@Path("/getestacoes")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estacao> getEstacoes() {
		return estacaoController.getEstacoesController();
	}

	@GET
	@Path("/getestacoesfuncionariosensores/{estacao_id}")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Estacao getEstacoesFuncionarios(
			@PathParam("estacao_id") String idEstacao) {
		return estacaoController
				.getEstacoesFuncionarioSensoresController(idEstacao);
	}

	@GET
	@Path("/getestacoessensoresdados")
	// @Produces("Application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estacao> getEstacoesSensoresDados() {
		return estacaoController.getEstacaoSensoresDadosController();
	}

	@Path("/{estacao_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Estacao getEstacaoSensoresDados(
			@PathParam("estacao_id") String estacaoId) {

		return estacaoController.getEstacaoController(estacaoId);

	}

	@Path("/id/{estacao_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Estacao getEstacaoAll(@PathParam("estacao_id") String estacaoId) {

		return estacaoController
				.getEstacaoFuncionarioSensoresDadosController(estacaoId);

	}

	@Path("/id/media/{estacao_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Estacao getEstacaoAllMedia(@PathParam("estacao_id") String estacaoId) {

		return estacaoController
				.getEstacaoFuncionarioSensoresMediaDadosController(estacaoId);

	}

}
