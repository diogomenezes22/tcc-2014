package br.edu.granbery.tcc.manager;

import java.util.List;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Pergunta;

@Local
public interface PerguntaManager {
	
	public Pergunta salvar(Pergunta pergunta);
	public List<Pergunta> consultar(Pergunta pergunta);
	public Pergunta buscarPerguntaAleatoria();

}
