package br.edu.granbery.manager;

import javax.ejb.Local;
import javax.inject.Named;

import br.edu.granbery.model.Jogador;

@Named
@Local
public interface JogadorManager{
	public Jogador salvar(Jogador jogador);
}