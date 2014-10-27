package br.edu.granbery.tcc.model;

import java.io.Serializable;

public class Tabuleiro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4696902666354720333L;
	
	private int id;
	private Casa[] casas;

	private static final String PRENDA = "PR";
	private static final String PERGUNTA = "PE";
	
	private int inicio;
	
	public Tabuleiro(){
		id = 1;
		casas = new Casa[41];
		for (int i = 0; i < casas.length; i++) {
			casas[i]= i %6 == 0 ?new Casa(PRENDA) : new Casa(PERGUNTA);					
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	
	public Casa[] getCasas() {
		return casas;
	}
	
	public void setCasas(Casa[] casas) {
		this.casas = casas;
	}
}
