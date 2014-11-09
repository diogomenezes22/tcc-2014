package br.edu.granbery.tcc.manager;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Jogador;


@Local
public interface JogadorManager{
	public Jogador salvar(Jogador jogador);

	public Jogador consultar(Jogador jogador);
	
	public List<Jogador> buscarTodos();

	public List<Jogador> buscarQuemVaiJogar();
	
	public void excluir(Jogador j);
	
	public Jogador alterar(Jogador jogador);
}