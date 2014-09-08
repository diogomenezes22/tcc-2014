package br.edu.granbery.tcc.view;

import java.io.Serializable;

import javax.inject.Named;

import br.edu.granbery.model.Jogador;
import br.edu.granbery.model.Jogo;
import br.edu.granbery.model.Pergunta;
import br.edu.granbery.model.Resposta;

@Named
public class GameControllerView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Jogo jogo = new Jogo();
	private Pergunta pergunta = new Pergunta();	
	private String repostaEscolhida;
	private Jogador jogadorAtual = new Jogador();
	private Resposta r1 = new Resposta();
	private Resposta r2 = new Resposta();
	private Resposta r3 = new Resposta();
	private Resposta r4 = new Resposta();
	
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

	public String getRepostaEscolhida() {
		return repostaEscolhida;
	}

	public void setRepostaEscolhida(String	 repostaEscolhida) {
		this.repostaEscolhida = repostaEscolhida;
	}

	public Resposta getR1() {
		return r1;
	}

	public void setR1(Resposta r1) {
		this.r1 = r1;
	}

	public Resposta getR2() {
		return r2;
	}

	public void setR2(Resposta r2) {
		this.r2 = r2;
	}

	public Resposta getR3() {
		return r3;
	}

	public void setR3(Resposta r3) {
		this.r3 = r3;
	}

	public Resposta getR4() {
		return r4;
	}

	public void setR4(Resposta r4) {
		this.r4 = r4;
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}
	
}
