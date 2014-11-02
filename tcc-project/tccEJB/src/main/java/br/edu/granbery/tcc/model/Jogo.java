package br.edu.granbery.tcc.model;

import java.io.Serializable;
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
	private List<Pergunta> perguntas;
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
	public void mover(final Jogador jog, final int numDado){
			for (int i = 0; i < tabuleiro.getCasas().length; i++) {
				if(tabuleiro.getCasas()[i].getJogadores().remove(jog)){
					i += numDado;
					i = i > 40? 40: i;
					tabuleiro.getCasas()[i].getJogadores().add(jog);
					return;
				}
			}
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
	
	
	
//	public  static void Main(String[] args){
//		List<Jogador> jogadores = new ArrayList<Jogador>();
//		Jogador renato = new Jogador("Renato");
//		Jogador ximpa = new Jogador("Ximpa");
//		Jogador webert = new Jogador("Webert");
//		Jogador rodrigo = new Jogador("Rodrigo");
//		jogadores.add(renato);
//		jogadores.add(ximpa);
//		jogadores.add(webert);
//		jogadores.add(rodrigo);
//		Jogo jogo = new Jogo(new Tabuleiro(), jogadores);
//		jogo.mover(renato, 5);
//		jogo.getTipoCasa(renato);		
//	}
	
	
	
}
