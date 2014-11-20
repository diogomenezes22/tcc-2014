package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;





import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;

@ManagedBean
@ViewScoped
public class PerguntaRespostaController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2376361657591540952L;
	private Pergunta pergunta;
	private List<Pergunta> perguntas;
	private Integer opcaoCorreta = -1;
	private int pagina = 1;
	
	@Inject
	PerguntaManager perguntaManager;
	
	@PostConstruct
	public void load(){
		pergunta = new Pergunta();
	}

	public Pergunta getPergunta() {		
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
		opcaoCorreta = pergunta.getRespostas().indexOf(pergunta.getRespostaCorreta());
	}
	
	public String salvar(){
		String mensagemErro = "";
		if(validaPergunta(mensagemErro)){
		pergunta.getRespostas().get(opcaoCorreta).setCorreta("C");
		perguntaManager.salvar(pergunta);
		pergunta = new Pergunta();
		opcaoCorreta = -1;
		return "salvo";
		}
		return mensagemErro;
	}
	
	private boolean validaPergunta(String mensagemErro) {
		if("".equals(pergunta.getDescricao())){
			mensagemErro ="A Pergunta não pode ser vazia!";
			return false;
		}
		if(opcaoCorreta ==-1){
			mensagemErro ="Favor marcar qual das opções está correta!";
			return false;
		}
		for (Resposta resp : pergunta.getRespostas()) {
			if("".equals(resp.getDescricao())){
				mensagemErro = "Todas as Respostas devem ser preenchidas!";
				return false;
			}
		}
		return true;
	}

	public void buscar(){
		if(pergunta == null)
			pergunta = new Pergunta();
		
		perguntas = perguntaManager.consultar(pergunta);		
		return ;
	}
	

	public int getOpcaoCorreta() {
		return opcaoCorreta;
	}

	public void setOpcaoCorreta(int opcaoCorreta) {
		this.opcaoCorreta = opcaoCorreta;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void editaPergunta(){
		
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public void editar(Pergunta pergunta){
		this.pergunta = pergunta;
	}

}
