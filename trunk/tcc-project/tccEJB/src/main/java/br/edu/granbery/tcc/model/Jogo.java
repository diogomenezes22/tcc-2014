package br.edu.granbery.tcc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

public class Jogo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -87919793536842201L;

	private int id;
	private Date dataInicio;
	private Date dataFim;
	private Tabuleiro tabuleiro;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	private List<Jogador> jogadores;
	
	public Jogo(Tabuleiro tab, List<Jogador> jogadores){
		dataInicio = new Date();
		tabuleiro = tab;
		this.jogadores = jogadores;
		tab.getCasas()[0].getJogadores().addAll(this.jogadores);
	}
	
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
	
	@Transient
	public boolean mover(final Jogador jog, final int numDado){
			for (int i = 0; i < tabuleiro.getCasas().length; i++) {
				if(tabuleiro.getCasas()[i].getJogadores().remove(jog)){
					i += numDado;
					i = i > 40? 40: i;
					tabuleiro.getCasas()[i].getJogadores().add(jog);
					return i==40;
				}
			}
			return false;
	}
	
	@Transient
	public String getTipoCasa(final Jogador jog){
		for (int i = 0; i < tabuleiro.getCasas().length; i++) {
			if(tabuleiro.getCasas()[i].getJogadores().contains(jog)){
				return tabuleiro.getCasas()[i].getTipo();
			}
		}
		return "";
	}
	
	@Transient
	public Jogador passaVez(Jogador jogadorAtual){
		for(int i=0; i < jogadores.size(); i++){
			if(jogadorAtual.equals(jogadores.get(i))){
				if(i == (jogadores.size()-1)){
					return jogadores.get(0);
				}else{
					return jogadores.get(i+1);
				}
			}
		}
		return null;
	}	
	
	
	
}
