package br.edu.granbery.tcc.dao;

import javax.inject.Named;

import br.edu.granbery.tcc.model.Jogador;


@Named
public interface JogadorDAO {
	public Jogador save(Jogador jogador) throws Exception;
}
