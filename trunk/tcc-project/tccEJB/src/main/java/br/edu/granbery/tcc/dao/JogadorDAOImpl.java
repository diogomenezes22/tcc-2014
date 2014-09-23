package br.edu.granbery.tcc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.edu.granbery.tcc.model.Jogador;


@Stateless
public class JogadorDAOImpl extends GenericDaoImpl<Jogador, Long> implements JogadorDAO{
	
	private final static String SELECT = "SELECT j FROM Jogador j WHERE 1=1";
	private boolean informouId, informouNome, informouIdade, informouPeriodo;
	
	
	public List<Jogador> findByParameters(final Jogador jog){
		StringBuffer query = new StringBuffer(SELECT);
		verificaParametros(jog);
		
		if(informouId)
			query.append("AND j.id = :id ");
		if(informouNome)
			query.append("AND UPPER(j.nome) LIKE :nome ");		
		if(informouIdade)
			query.append("AND j.idade = :idade ");			
		if(informouPeriodo)
			query.append("AND j.periodo = :periodo ");		
		
		Query q = super.getEntityManager().createQuery(query.toString());
		if(informouId)
		q.setParameter("id", jog.getId());
		if(informouNome)
		q.setParameter("nome", jog.getNome());
		if(informouIdade)
		q.setParameter("idade", jog.getIdade());
		if(informouPeriodo)
		q.setParameter("periodo", jog.getPeriodo());
		
		return q.getResultList();
		
	}

	private void verificaParametros(final Jogador jog) {
		informouId = jog.getId() != null; 
		informouNome = jog.getNome() != null && !"".equals(jog.getNome()); 
		informouIdade = jog.getIdade() != null && !Integer.valueOf(0).equals(jog.getIdade()); 
		informouPeriodo = jog.getPeriodo() != null && !"".equals(jog.getPeriodo());
	}
}
