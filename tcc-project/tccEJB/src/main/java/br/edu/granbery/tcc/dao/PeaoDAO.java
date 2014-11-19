package br.edu.granbery.tcc.dao;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Peao;


@Local
public interface PeaoDAO extends GenericDao<Peao, Long> {
	
	public List<Peao> findByParameters(final Peao jog);

	public List<Peao> buscarPeoesEmJogo();

	public void limparJogo();
	
}
