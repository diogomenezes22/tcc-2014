package br.edu.granbery.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.granbery.model.Jogador;


@Stateless
public class JogadorDAOImpl implements JogadorDAO{
	
	@PersistenceContext(unitName="tccEJB")
	EntityManager manager;
		
	public Jogador save(Jogador jogador) throws Exception {
		manager.persist(jogador);
		return jogador;
	}
}
