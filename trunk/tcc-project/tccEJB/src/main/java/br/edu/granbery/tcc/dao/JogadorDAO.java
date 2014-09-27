package br.edu.granbery.tcc.dao;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Jogador;


@Local
public interface JogadorDAO extends GenericDao<Jogador, Long> {
	
	public List<Jogador> findByParameters(final Jogador jog);

	public List<Jogador> buscarQuemVaiJogar();
	
}
