package br.edu.granbery.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_JOGADOR")
public class Jogador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5445385721352730525L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_JOGADOR")
	private Long id;
	
	@Column(name="DE_NOME")
	private String nome;
	
	@Column(name="ID_PERIODO")
	private String periodo;
	
	@Column(name="NU_IDADE")
	private Integer idade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
