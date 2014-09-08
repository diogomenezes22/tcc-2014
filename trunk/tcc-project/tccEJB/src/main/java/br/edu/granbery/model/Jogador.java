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
	private boolean podeAndar;
	private int posicaoAtual;
	private int proximaPosicao;
	
	@Override
	public String toString(){
		return id + ","+ nome + "," + posicaoAtual + "," + podeAndar + "," + proximaPosicao;
		
	}
	
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
	
	
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	public void setPosicaoAtual(int posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}
	public boolean isPodeAndar() {
		return podeAndar;
	}
	public void setPodeAndar(boolean podeAndar) {
		this.podeAndar = podeAndar;
	}
	public int getProximaPosicao() {
		return proximaPosicao;
	}
	public void setProximaPosicao(int proximaPosicao) {
		this.proximaPosicao = proximaPosicao;
	}
	
}
