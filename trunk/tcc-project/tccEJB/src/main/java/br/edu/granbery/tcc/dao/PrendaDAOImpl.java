package br.edu.granbery.tcc.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Prenda;


@Stateless
public class PrendaDAOImpl extends GenericDaoImpl<Prenda, Long> implements PrendaDAO{
	
	public void excluir(Prenda p){
	      super.delete(getEntityManager().getReference(Prenda.class, p.getId()));
	}
	
	public Prenda buscarPrenda(Integer id){
		StringBuilder sb = new StringBuilder();
		sb.append("FROM Prenda p WHERE");
		sb.append(" p.id= :id");
		
		Query query = getEntityManager().createQuery(sb.toString());
		query.setParameter("id", id);
		
		try {
			return (Prenda) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}

	public Prenda buscarPerguntaAleatoria() {
			String jpql = "SELECT p FROM Prenda p ORDER BY RAND()";
			Query query = getEntityManager().createQuery(jpql);
			Prenda prenda = (Prenda) query.getResultList().get(0);
			return prenda;
	}
	
}
