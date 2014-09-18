package br.edu.granbery.model;

import java.io.Serializable;

import javax.ejb.Local;
import javax.persistence.*;

@Entity
@Table(name="jogador")
@Local
public class Jogador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5445385721352730525L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="VEZ")
	private boolean vez;
	
	@OneToOne
	@JoinColumn(name="PEAO_ID")
	private Peao peao;
	
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
