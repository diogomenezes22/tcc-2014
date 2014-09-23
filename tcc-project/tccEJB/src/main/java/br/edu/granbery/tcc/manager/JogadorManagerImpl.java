package br.edu.granbery.tcc.manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.granbery.tcc.dao.JogadorDAO;
import br.edu.granbery.tcc.model.Jogador;



@Stateless
public class JogadorManagerImpl implements JogadorManager{
	
	@Inject
	JogadorDAO jogadorDAO;
	
	public Jogador salvar(Jogador jogador) {
		try {
			jogadorDAO.saveOrUpdate(jogador);
			return jogador;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Jogador consultar(Jogador jogador) {
		try {
			List<Jogador> jogadores = jogadorDAO.findByParameters(jogador);
			return jogadores.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




}
