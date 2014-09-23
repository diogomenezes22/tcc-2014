package br.edu.granbery.tcc.manager;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Jogador;


@Local
public interface JogadorManager{
	public Jogador salvar(Jogador jogador);

	public Jogador consultar(Jogador jogador);
}