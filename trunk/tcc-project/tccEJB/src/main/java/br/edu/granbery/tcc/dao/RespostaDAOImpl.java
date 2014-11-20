package br.edu.granbery.tcc.dao;

import javax.ejb.Stateless;

import br.edu.granbery.tcc.model.Resposta;

@Stateless
public class RespostaDAOImpl extends GenericDaoImpl<Resposta, Long> implements	RespostaDAO {

	@Override
	public void saveOrUpdate(Resposta resposta){
		if(resposta.getId() != null)
			resposta = getEntityManager().getReference(Resposta.class, resposta.getId());
		
		super.saveOrUpdate(resposta);
	}

}
