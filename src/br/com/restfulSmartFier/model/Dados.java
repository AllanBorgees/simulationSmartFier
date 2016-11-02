package br.com.restfulSmartFier.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dados {

	
	private String _dtepoch;
	private String _dtiso;
	private String valor;
	
	
	
	public Dados(){
		
	}
	
	public Dados(String _dtepoch, String _dtiso, String valor) {
		super();
		this._dtepoch = _dtepoch;
		this._dtiso = _dtiso;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Dados [_dtepoch=" + _dtepoch + ", _dtiso=" + _dtiso + ", valor="
				+ valor + "]";
	}

	public String get_dtepoch() {
		return _dtepoch;
	}

	public void set_dtepoch(String _dtepoch) {
		this._dtepoch = _dtepoch;
	}

	public String get_dtiso() {
		return _dtiso;
	}

	public void set_dtiso(String _dtiso) {
		this._dtiso = _dtiso;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
}
