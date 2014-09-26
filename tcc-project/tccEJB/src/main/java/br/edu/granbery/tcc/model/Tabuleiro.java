package br.edu.granbery.tcc.model;

import java.io.Serializable;
import java.util.List;

public class Tabuleiro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4696902666354720333L;
	
	private int id;
	private List<Casa> casas;
	private List<Peao> peoes;
	private int inicio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Casa> getCasas() {
		return casas;
	}
	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public List<Peao> getPeoes() {
		return peoes;
	}
	public void setPeoes(List<Peao> peoes) {
		this.peoes = peoes;
	}
	
}
