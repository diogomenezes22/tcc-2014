package br.edu.granbery.tcc.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.dao.PrendaDAO;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Prenda;


@Named
@Stateless
public class PrendaManagerImpl implements PrendaManager, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	PrendaDAO prendaDAO;
	
	public Prenda salvar(Prenda prenda) {
		try {
			prendaDAO.saveOrUpdate(prenda);
			return prenda;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Prenda alterar(Prenda prenda) {
		try {
			prendaDAO.atualizar(prenda);
			return prenda;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Prenda recuperarPrenda(Integer id){
		return prendaDAO.buscarPrenda(id);
	}
	
	public List<Prenda> recuperarPrendas(){
		return prendaDAO.findAll(Prenda.class);
	}
	
	public void excluir(Prenda prenda){
		prendaDAO.excluir(prenda);
	}

	public Prenda buscarPrendaAleatoria() {
		return prendaDAO.buscarPerguntaAleatoria();
	}
	

}
