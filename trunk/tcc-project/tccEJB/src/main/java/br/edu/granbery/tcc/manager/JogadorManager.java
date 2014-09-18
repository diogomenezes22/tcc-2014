package br.edu.granbery.tcc.manager;

import javax.ejb.Local;
import javax.inject.Named;

import br.edu.granbery.tcc.model.Jogador;

@Named
@Local
public interface JogadorManager{
	public Jogador salvar(Jogador jogador);
}