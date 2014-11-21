package br.edu.granbery.tcc.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Peao;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Prenda;


@Named
@SessionScoped
public class GameControllerView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pergunta pergunta;	
	private Prenda prenda;
	private String repostaEscolhida;
	private Jogador jogadorAtual;
	private String numeroSorteado;
	
	//Controle Javascript muito Importante
	private List<Peao> listaPeoes;
	private Peao peaoEmJogo;

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public List<Peao> getListaPeoes() {
		return listaPeoes;
	}

	public void setListaPeoes(List<Peao> listaPeoes) {
		this.listaPeoes = listaPeoes;
	}

	public Peao getPeaoEmJogo() {
		return peaoEmJogo;
	}

	public void setPeaoEmJogo(Peao peaoEmJogo) {
		this.peaoEmJogo = peaoEmJogo;
	}

	public String getRepostaEscolhida() {
		return repostaEscolhida;
	}

	public void setRepostaEscolhida(String repostaEscolhida) {
		this.repostaEscolhida = repostaEscolhida;
	}

	public String getNumeroSorteado() {
		return numeroSorteado;
	}

	public void setNumeroSorteado(String numeroSorteado) {
		this.numeroSorteado = numeroSorteado;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
}
