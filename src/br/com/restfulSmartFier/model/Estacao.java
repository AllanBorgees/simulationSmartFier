package br.com.restfulSmartFier.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Estacao {

	private String estacao_id;
	private String descricao;
	private String ip;
	private String nome_estacao;
	private String modelo;
	private String endereco;
	private Funcionario funcionario;
	private ArrayList<Sensor> sensores;
	private String status;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getEstacao_id() {
		return estacao_id;
	}

	public void setEstacao_id(String estacao_id) {
		this.estacao_id = estacao_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNome_estacao() {
		return nome_estacao;
	}

	public void setNome_estacao(String nome_estacao) {
		this.nome_estacao = nome_estacao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Estacao() {

	}

	public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Estacao [estacao_id=" + estacao_id + ", descricao=" + descricao
				+ ", ip=" + ip + ", nome_estacao=" + nome_estacao + ", modelo="
				+ modelo + ", endereco=" + endereco + ", funcionario="
				+ funcionario + ", sensores=" + sensores + "]";
	}
	
	

}
