package br.edu.granbery.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Jogo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -87919793536842201L;

	private int id;
	private Date dataInicio;
	private Date dataFim;
	private Tabuleiro tabuleiro;
	private List<Pergunta> perguntas;
	private List<Jogador> jogadores;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
}
