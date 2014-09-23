package br.edu.granbery.tcc.dao;

import javax.ejb.Stateless;

import br.edu.granbery.tcc.model.Pergunta;

@Stateless
public class PerguntaDAOImpl extends GenericDaoImpl<Pergunta, Long> implements PerguntaDAO {	
	
	@Override
	public void saveOrUpdate(Pergunta pergunta){
		super.saveOrUpdate(pergunta);
	}
}
