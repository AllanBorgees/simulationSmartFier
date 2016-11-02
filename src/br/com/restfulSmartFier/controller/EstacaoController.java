package br.com.restfulSmartFier.controller;

import java.util.ArrayList;

import br.com.restfulSmartFier.dao.EstacaoDAO;
import br.com.restfulSmartFier.factory.Email;
import br.com.restfulSmartFier.model.Estacao;

public class EstacaoController {

	private static EstacaoController estacaoCon = new EstacaoController();

	private EstacaoController() {

	}

	public static EstacaoController getInstancia() {
		return estacaoCon;
	}

	EstacaoDAO dao = EstacaoDAO.getInstancia();

	/**
	 * 
	 * @param estacaoId
	 * @return Lista a estacao com os sensores e dados vinculados
	 */
	public Estacao getEstacaoController(String estacaoId) {
		return dao.getEstacaoFuncionariosSensoresDadosByIdDAO(estacaoId);
		// return dao.getEstacaoSensoresDadosByIdDAO(estacaoId);
	}

	public void enviarEmail(String estacaoId){
		Estacao estacao = dao.getEstacaoFuncionarioSensoresDAO(estacaoId);
		Email email = new Email();
		email.enviarEmail(estacao);
	}
	
	
	
	/**
	 * 
	 * @return Todas a estacoes sem vinculo algum
	 */
	public ArrayList<Estacao> getEstacoesController() {
		return dao.getEstacoesDAO();
	}

	/**
	 * 
	 * @return Retorna todas as estacoes com seus funcionarios
	 */
	public Estacao getEstacoesFuncionarioSensoresController(String estacaoId) {

		return dao.getEstacaoFuncionarioSensoresDAO(estacaoId);

	}


	/**
	 * 
	 * @return Todas as estacoes com sensores e dados vinculados
	 */
	public ArrayList<Estacao> getEstacaoSensoresDadosController() {
		return dao.getEstacaoSensoresDadosDAO();
	}

	public Estacao getEstacaoFuncionarioSensoresDadosController(String estacaoId) {
		return dao.getEstacaoFuncionariosSensoresDadosByIdDAO(estacaoId);
	}


	public Estacao getEstacaoFuncionarioSensoresMediaDadosController(String estacaoId) {
		return dao.getEstacaoFuncionariosSensoresMediaDadosByIdDAO(estacaoId);
	}

	public static void main(String[] args) {
		new EstacaoController().getEstacoesFuncionarioSensoresController("estacao000");
	}
	
	
	
}
