package br.edu.granbery.tcc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.edu.granbery.tcc.model.Pergunta;

@Stateless
public class PerguntaDAOImpl extends GenericDaoImpl<Pergunta, Long> implements PerguntaDAO {	
	
	private final static String SELECT = "SELECT DISTINCT(p) FROM Pergunta p JOIN FETCH p.respostas r WHERE 1=1 ";
	
	@Override
	public void saveOrUpdate(Pergunta pergunta){
		if(pergunta.getId() != null)
			pergunta = getEntityManager().getReference(Pergunta.class, pergunta.getId());
		
		super.saveOrUpdate(pergunta);
	}

	public Pergunta buscarPerguntaAleatoria() {
		String jpql = "SELECT p FROM Pergunta p JOIN FETCH p.respostas ORDER BY RAND()";
		Query query = getEntityManager().createQuery(jpql);
		Pergunta pergunta = (Pergunta) query.getResultList().get(0);
		return pergunta;
	}
	
	public List<Pergunta> findByParameters(final Pergunta perg){
		StringBuffer query = new StringBuffer(SELECT);		
		query.append("AND UPPER(p.descricao) LIKE :descricao ");
		Query q = super.getEntityManager().createQuery(query.toString());		
		q.setParameter("descricao", "%"+perg.getDescricao().toUpperCase()+"%");
		return q.getResultList();
		
	}
}
