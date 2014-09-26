package br.edu.granbery.tcc.manager;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Peao;


@Local
public interface PeaoManager{
	public Peao salvar(Peao peao);

	public Peao consultar(Peao peao);
	
	public List<Peao> buscarTodos();
}