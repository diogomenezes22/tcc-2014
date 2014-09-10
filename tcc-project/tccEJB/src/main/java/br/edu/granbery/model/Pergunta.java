package br.edu.granbery.model;

import java.io.Serializable;
import java.util.List;

public class Pergunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5604715434504864824L;
	
	private int id;
	private String descricao;
	private boolean repetida;
	private List<Resposta> respostas;
	
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
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}
