package br.edu.granbery.model;

import java.io.Serializable;

public class Resposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2028054062176867907L;
	
	private int id;
	private char alternativa;
	private String descricao;
	private boolean correta;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(char alternativa) {
		this.alternativa = alternativa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isCorreta() {
		return correta;
	}
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alternativa;
		result = prime * result + (correta ? 1231 : 1237);
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
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
		Resposta other = (Resposta) obj;
		if (alternativa != other.alternativa)
			return false;
		if (correta != other.correta)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
