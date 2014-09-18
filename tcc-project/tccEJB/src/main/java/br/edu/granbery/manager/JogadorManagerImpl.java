package br.edu.granbery.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.granbery.dao.JogadorDAO;
import br.edu.granbery.model.Jogador;



@Stateless
public class JogadorManagerImpl implements JogadorManager{
	
	@Inject
	JogadorDAO usuarioDAO;
	
	public Jogador salvar(Jogador jogador) {
		try {
			usuarioDAO.save(jogador);
			return jogador;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




}