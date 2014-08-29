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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + (repetida ? 1231 : 1237);
		result = prime * result
				+ ((respostas == null) ? 0 : respostas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (repetida != other.repetida)
			return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		return true;
	}
	
	

	
}
