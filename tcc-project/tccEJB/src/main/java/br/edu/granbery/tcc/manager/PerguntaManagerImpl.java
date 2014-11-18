package br.edu.granbery.tcc.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import br.edu.granbery.tcc.dao.PerguntaDAO;
import br.edu.granbery.tcc.dao.RespostaDAO;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;

@Stateless
public class PerguntaManagerImpl implements PerguntaManager, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	PerguntaDAO perguntaDAO;
	
	@Inject
	RespostaDAO respostaDAO;
	
	public Pergunta salvar(Pergunta pergunta) {
		try {
			for(Resposta resp : pergunta.getRespostas()){
				if(resp.getCorreta().isEmpty()){
					resp.setCorreta(Resposta.ERRADA);
				}
			}
			
			perguntaDAO.saveOrUpdate(pergunta);
			if(pergunta.getRespostas().size() > 0){
				for (Resposta resp : pergunta.getRespostas()) {
					if(resp.getDescricao() != null && !"".equals(resp.getDescricao())){
						respostaDAO.saveOrUpdate(resp);						
					}
				}
			}
			return pergunta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pergunta buscarPerguntaAleatoria() {
		Pergunta pergunta = perguntaDAO.buscarPerguntaAleatoria();
		return pergunta;
	}
	
	public Pergunta consultar(Pergunta pergunta) {
		try {
			List<Pergunta> perguntas = perguntaDAO.findByParameters(pergunta);			
			return perguntas.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
