package br.edu.granbery.tcc.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Jogo;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Tabuleiro;


@Named
@SessionScoped
public class GameControllerView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Jogo jogo = new Jogo(new Tabuleiro(), new ArrayList<Jogador>());
	private Pergunta pergunta = new Pergunta();	
	private String repostaEscolhida;
	private Jogador jogadorAtual = new Jogador();
	
	//variaveis para controle na parte javascript
	private String idPeao;
	private String nome;
	private boolean podeAndar;
	private int posicaoAtual;
	private int proximaPosicao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPodeAndar() {
		return podeAndar;
	}

	public void setPodeAndar(boolean podeAndar) {
		this.podeAndar = podeAndar;
	}

	public int getPosicaoAtual() {
		return posicaoAtual;
	}

	public void setPosicaoAtual(int posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	public int getProximaPosicao() {
		return proximaPosicao;
	}

	public void setProximaPosicao(int proximaPosicao) {
		this.proximaPosicao = proximaPosicao;
	}

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

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public String getIdPeao() {
		return idPeao;
	}

	public void setIdPeao(String idPeao) {
		this.idPeao = idPeao;
	}
}
