package br.edu.granbery.tcc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.edu.granbery.tcc.model.Peao;


@Stateless
public class PeaoDAOImpl extends GenericDaoImpl<Peao, Long> implements PeaoDAO{
	
	private final static String SELECT = "SELECT p FROM Peao p WHERE 1=1 ";
	private boolean informouId, informouDescricao, informouCor, informouPosicaoAtual;
	
	
	public List<Peao> findByParameters(final Peao peao){
		StringBuffer query = new StringBuffer(SELECT);
		verificaParametros(peao);
		
		if(informouId)
			query.append("AND p.id = :id ");
		if(informouDescricao)
			query.append("AND UPPER(p.descricao) LIKE :descricao ");		
		if(informouCor)
			query.append("AND p.cor = :cor ");			
		if(informouPosicaoAtual)
			query.append("AND p.posicao = :posicao ");		
		
		Query q = super.getEntityManager().createQuery(query.toString());
		if(informouId)
		q.setParameter("id", peao.getId());
		if(informouDescricao)
		q.setParameter("descricao", peao.getDescricao());
		if(informouCor)
		q.setParameter("cor", peao.getCor());
		if(informouPosicaoAtual)
		q.setParameter("posicao", peao.getPosicaoAtual());
		
		return q.getResultList();
		
	}

	private void verificaParametros(final Peao peao) {
		informouId = peao.getId() != null ; 
		informouDescricao = peao.getDescricao() != null && !"".equals(peao.getDescricao()); 
		informouCor = peao.getCor() != null && !Integer.valueOf(0).equals(peao.getCor()); 
		informouPosicaoAtual = peao.getPosicaoAtual() != null && !"".equals(peao.getPosicaoAtual());
	}
	
	@Override
	public void saveOrUpdate(Peao peao){
		Peao peaoPersistir = getEntityManager().getReference(Peao.class, peao.getId());
		peaoPersistir.setJogador(peao.getJogador());
		
		super.saveOrUpdate(peaoPersistir);
	}

	public List<Peao> buscarPeoesEmJogo() {
		String jpql = "SELECT DISTINCT p FROM Peao p JOIN p.jogador";
		Query query = getEntityManager().createQuery(jpql);
		List<Peao> listaPeoes = query.getResultList();
		return listaPeoes;
	}

	public void limparJogo() {
		List<Peao> listaPeoes = findAll(Peao.class);
		for (Peao peao : listaPeoes) {
			peao.setJogador(null);
			saveOrUpdate(peao);
		}
		
		
	}
}
