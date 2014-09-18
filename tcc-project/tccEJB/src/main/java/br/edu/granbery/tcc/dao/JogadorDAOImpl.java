package br.edu.granbery.tcc.dao;

import javax.ejb.Stateless;
import javax.persistence.*;

import br.edu.granbery.tcc.model.Jogador;


@Stateless
public class JogadorDAOImpl implements JogadorDAO{
	
	@PersistenceContext(unitName="tccEJB")
	EntityManager manager;
		
	public Jogador save(Jogador jogador) throws Exception {
		manager.persist(jogador);
		return jogador;
	}
}
