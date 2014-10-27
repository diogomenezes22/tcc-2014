package br.edu.granbery.tcc.model;

import java.io.Serializable;
import java.util.Set;

public class Casa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 49080706487491416L;	
	
	private String tipo;
	private Set<Jogador> jogadores;	
	
	public Casa(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Set<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(Set<Jogador> jogadores) {
		this.jogadores = jogadores;
	}	
}
