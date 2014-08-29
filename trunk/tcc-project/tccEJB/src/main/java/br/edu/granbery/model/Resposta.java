package br.edu.granbery.model;

import java.io.Serializable;

public class Resposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2028054062176867907L;
	
	private int id;
	private char alternativa;
	private String descri��o;
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
	public String getDescri��o() {
		return descri��o;
	}
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
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
				+ ((descri��o == null) ? 0 : descri��o.hashCode());
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
		if (descri��o == null) {
			if (other.descri��o != null)
				return false;
		} else if (!descri��o.equals(other.descri��o))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
