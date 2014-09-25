package br.edu.granbery.tcc.dao;

import java.util.List;

import br.edu.granbery.tcc.model.Pergunta;

public interface PerguntaDAO extends GenericDao<Pergunta, Long> {
	public List<Pergunta> findByParameters(final Pergunta perg);

	Pergunta buscarPerguntaAleatoria();
	
}
