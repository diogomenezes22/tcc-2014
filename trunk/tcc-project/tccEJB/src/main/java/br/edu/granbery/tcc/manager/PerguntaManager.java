package br.edu.granbery.tcc.manager;

import javax.ejb.Local;

import br.edu.granbery.tcc.model.Pergunta;

@Local
public interface PerguntaManager {
	
	public Pergunta salvar(Pergunta pergunta);

}
