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
import javax.persistence.Transient;

@Entity
@Table(name="TB_RESPOSTA")
public class Resposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2028054062176867907L;
			
	public static final String CORRETA ="C";
	public static final String ERRADA ="E";
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESPOSTA")
	private Long id;	
	
	@JoinColumn(name = "ID_PERGUNTA", referencedColumnName = "ID_PERGUNTA", updatable = false)
	@ManyToOne(optional = true)
	private Pergunta pergunta;	

	@Column(name="DE_RESPOSTA")
	private String descricao;
	
	@Column(name="IC_CORRETA")
	private String correta;
	
	public Resposta(Pergunta perg){
		pergunta = perg;
		descricao = "";
		correta = "ERRADA";
	}
	
	public Resposta(){
		descricao = "";
		correta = ERRADA;
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
	
	public void setCorreta(String correta) {
		this.correta = correta;
	}
	public String getCorreta(){
		return correta;
	}
	
	public void setRespostaCerta(){
		this.correta = "CORRETA";
	}
	
	@Transient
	public boolean isCorreta(){
		return "CORRETA".equals(correta);
	}
	
	
}
