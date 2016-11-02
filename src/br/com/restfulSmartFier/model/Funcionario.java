package br.com.restfulSmartFier.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funcionario implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private int funcionario_id;
	private String nome;
	private String cpf;
	private String email;
	private String tipo;
	private String login;
	private String senha;

	public Funcionario() {

	}
 
 
	@Override
	public String toString() {
		return "Funcionario [funcionario_id=" + funcionario_id + ", nome="
				+ nome + ", cpf=" + cpf + ", email=" + email + ", tipo=" + tipo
				+ ", login=" + login + ", senha=" + senha + "]";
	}


	public Funcionario(int funcionario_id, String nome, String cpf,
			String email, String tipo, String login, String senha) {
		super();
		this.funcionario_id = funcionario_id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.tipo = tipo;
		this.login = login;
		this.senha = senha;
	}


	public int getFuncionario_id() {
		return funcionario_id;
	}


	public void setFuncionario_id(int funcionario_id) {
		this.funcionario_id = funcionario_id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// public Usuario getUsuario() {
	// return usuario;
	// }
	// public void setUsuario(Usuario usuario) {
	// this.usuario = usuario;
	// }

}
