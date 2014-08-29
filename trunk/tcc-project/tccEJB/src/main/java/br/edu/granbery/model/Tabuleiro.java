package br.edu.granbery.model;

import java.io.Serializable;
import java.util.List;

public class Tabuleiro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4696902666354720333L;
	
	private int id;
	private List<Casa> casas;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casas == null) ? 0 : casas.hashCode());
		result = prime * result + id;
		result = prime * result + inicio;
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
		Tabuleiro other = (Tabuleiro) obj;
		if (casas == null) {
			if (other.casas != null)
				return false;
		} else if (!casas.equals(other.casas))
			return false;
		if (id != other.id)
			return false;
		if (inicio != other.inicio)
			return false;
		return true;
	}
	
	

}
