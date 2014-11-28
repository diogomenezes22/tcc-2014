package br.edu.granbery.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRENDA")
public class Prenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309375743194210618L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="repetida")
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
