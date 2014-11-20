package br.edu.granbery.tcc.dao;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Prenda;


@Local
public interface PrendaDAO extends GenericDao<Prenda, Long> {
	
	public void excluir(Prenda p);
	
	public Prenda buscarPrenda(Integer id);

	public Prenda buscarPerguntaAleatoria();
}
