package br.edu.granbery.dao;

import javax.ejb.Local;
import javax.inject.Named;

import br.edu.granbery.model.Jogador;


@Local
@Named
public interface JogadorDAO {
	public Jogador save(Jogador jogador) throws Exception;
}
