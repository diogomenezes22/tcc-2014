package br.edu.granbery.tcc.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;

@Named
@RequestScoped
public class PerguntaRespostaController {
	
	private Pergunta pergunta;
	
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
	}
	
	public String salvar(){
		perguntaManager.salvar(pergunta);
		pergunta = new Pergunta();
		return "salvo";
	}
	
	public void buscar(){
		pergunta = perguntaManager.consultar(pergunta);		
		return ;
	}

}
