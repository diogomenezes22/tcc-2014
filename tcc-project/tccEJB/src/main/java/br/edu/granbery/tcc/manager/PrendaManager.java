package br.edu.granbery.tcc.manager;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Prenda;


@Local
public interface PrendaManager{
	public Prenda salvar(Prenda prenda);
	
	public List<Prenda> recuperarPrendas();
	
	public void excluir(Prenda prenda);
	
	public Prenda alterar(Prenda prenda);
	
	public Prenda recuperarPrenda(Integer id);

}