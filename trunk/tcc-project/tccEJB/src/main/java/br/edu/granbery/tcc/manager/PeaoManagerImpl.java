package br.edu.granbery.tcc.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.dao.PeaoDAO;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Peao;


@Named
@Stateless
public class PeaoManagerImpl implements PeaoManager, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	PeaoDAO peaoDAO;
	
	public Peao salvar(Peao peao) {
		try {
			peaoDAO.saveOrUpdate(peao);
			return peao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Peao consultar(Peao peao) {
		try {
			List<Peao> peoes = peaoDAO.findByParameters(peao);
			return peoes.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Peao> buscarTodos() {
		try {
			List<Peao> peoes = peaoDAO.findAll(Peao.class);
			return peoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Peao> buscarPeoesEmJogo() {
		try {
			List<Peao> peoes = peaoDAO.buscarPeoesEmJogo();
			return peoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void limparJogo() {
		peaoDAO.limparJogo();
	}

	

}
