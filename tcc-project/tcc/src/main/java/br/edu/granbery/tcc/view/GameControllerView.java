package br.edu.granbery.tcc.view;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.edu.granbery.model.Jogo;
import br.edu.granbery.model.Pergunta;

@Named
@ViewScoped
public class GameControllerView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Jogo jogo = new Jogo();
	private Pergunta pergunta = new Pergunta();	
	private boolean repostaEscolhida;
	private boolean mostrarPergunta = false;
	
	private String variavelTeste;

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public boolean isRepostaEscolhida() {
		return repostaEscolhida;
	}

	public void setRepostaEscolhida(boolean repostaEscolhida) {
		this.repostaEscolhida = repostaEscolhida;
	}

	public boolean isMostrarPergunta() {
		return mostrarPergunta;
	}

	public void setMostrarPergunta(boolean mostrarPergunta) {
		this.mostrarPergunta = mostrarPergunta;
	}

	public String getVariavelTeste() {
		return variavelTeste;
	}

	public void setVariavelTeste(String variavelTeste) {
		this.variavelTeste = variavelTeste;
	}
}
