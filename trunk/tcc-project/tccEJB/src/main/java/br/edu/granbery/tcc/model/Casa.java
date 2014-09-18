package br.edu.granbery.tcc.model;

import java.io.Serializable;

public class Casa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 49080706487491416L;
	
	private int id;
	private String tipo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
