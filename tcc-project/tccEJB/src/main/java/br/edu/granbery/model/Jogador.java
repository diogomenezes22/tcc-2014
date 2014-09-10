package br.edu.granbery.model;

import java.io.Serializable;

public class Jogador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5445385721352730525L;
	
	private int id;
	private String nome;
	private boolean vez;
	
	private Peao peao = new Peao();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isVez() {
		return vez;
	}
	public void setVez(boolean vez) {
		this.vez = vez;
	}
	public Peao getPeao() {
		return peao;
	}
	public void setPeao(Peao peao) {
		this.peao = peao;
	}
	
}
