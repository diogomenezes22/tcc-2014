package br.edu.granbery.tcc.view;

import javax.inject.Named;

import br.edu.granbery.model.Jogador;

@Named
public class JogadorView {
	private Jogador jogador = new Jogador();

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
