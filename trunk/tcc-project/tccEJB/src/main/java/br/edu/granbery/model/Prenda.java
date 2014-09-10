package br.edu.granbery.model;

import java.io.Serializable;

public class Prenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309375743194210618L;
	
	private int id;
	private String descricao;
	private boolean repetida;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isRepetida() {
		return repetida;
	}
	public void setRepetida(boolean repetida) {
		this.repetida = repetida;
	}
	
}
