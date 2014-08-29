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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + (repetida ? 1231 : 1237);
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
		Prenda other = (Prenda) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (repetida != other.repetida)
			return false;
		return true;
	}
	
	
}
