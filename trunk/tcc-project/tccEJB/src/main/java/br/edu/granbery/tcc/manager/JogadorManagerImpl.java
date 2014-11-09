package br.edu.granbery.tcc.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.dao.JogadorDAO;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Prenda;


@Named
@Stateless
public class JogadorManagerImpl implements JogadorManager, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public List<Jogador> buscarTodos() {
		try {
			List<Jogador> jogadores = jogadorDAO.findAll(Jogador.class);
			return jogadores;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Jogador> buscarQuemVaiJogar() {
		try {
			List<Jogador> jogadores = jogadorDAO.buscarQuemVaiJogar();
			return jogadores;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void excluir(Jogador j){
		jogadorDAO.excluir(j);
	}
	
	public Jogador alterar(Jogador jogador){
		try {
			jogadorDAO.atualizar(jogador);
			return jogador;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
