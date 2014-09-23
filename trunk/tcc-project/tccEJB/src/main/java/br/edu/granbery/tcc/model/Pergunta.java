package br.edu.granbery.tcc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PERGUNTA")
public class Pergunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5604715434504864824L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERGUNTA")
	private Long id;	
	
	@Column(name="DE_PERGUNTA")
	private String descricao;
	
	@OneToMany(mappedBy = "pergunta")
	private List<Resposta> respostas;
	
	public Pergunta(){
		respostas = new ArrayList<Resposta>();
		descricao = "";
		for (int i = 0; i < 4; i++) {
			respostas.add(new Resposta(this));			
		}
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
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}
