package br.com.restfulSmartFier.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Sensor {

	private String sensor_id;
	private String grandeza;
	private String modelo;
	private String inteiro;
	private ArrayList<Dados> dados;

	public Sensor() {

	}

	public String getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}

	public String getGrandeza() {
		return grandeza;
	}

	public void setGrandeza(String grandeza) {
		this.grandeza = grandeza;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getInteiro() {
		return inteiro;
	}

	public void setInteiro(String inteiro) {
		this.inteiro = inteiro;
	}

	public ArrayList<Dados> getDados() {
		return dados;
	}

	public void setDados(ArrayList<Dados> dados) {
		this.dados = dados;
	}

	@Override
	public String toString() {
		return "Sensor [sensor_id=" + sensor_id + ", grandeza=" + grandeza
				+ ", modelo=" + modelo + ", inteiro=" + inteiro + ", dados="
				+ dados + "]";
	}

	public Sensor(String sensor_id, String grandeza, String modelo,
			String inteiro, ArrayList<Dados> dados) {
		super();
		this.sensor_id = sensor_id;
		this.grandeza = grandeza;
		this.modelo = modelo;
		this.inteiro = inteiro;
		this.dados = dados;
	}

}
