package br.edu.granbery.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESPOSTA")
public class Resposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2028054062176867907L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESPOSTA")
	private Long id;	
	
	@JoinColumn(name = "ID_PERGUNTA", referencedColumnName = "ID_PERGUNTA", updatable = false)
	@ManyToOne(optional = true)
	private Pergunta pergunta;	

	@Column(name="DE_RESPOSTA")
	private String descricao;
	
	public Resposta(Pergunta perg){
		pergunta = perg;
		descricao = "";
	}
	
	public Resposta(){
		descricao = "";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
		
}
