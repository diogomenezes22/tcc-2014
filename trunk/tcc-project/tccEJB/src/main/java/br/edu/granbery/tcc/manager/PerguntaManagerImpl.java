package br.edu.granbery.tcc.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.granbery.tcc.dao.PerguntaDAO;
import br.edu.granbery.tcc.dao.RespostaDAO;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;

@Stateless
public class PerguntaManagerImpl implements PerguntaManager {
	
	@Inject
	PerguntaDAO perguntaDAO;
	
	@Inject
	RespostaDAO respostaDAO;
	
	public Pergunta salvar(Pergunta pergunta) {
		try {
			perguntaDAO.saveOrUpdate(pergunta);
			if(pergunta.getRespostas().size() > 0){
				for (Resposta resp : pergunta.getRespostas()) {					
					respostaDAO.saveOrUpdate(resp);
				}
			}
			return pergunta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public Pergunta consultar(Pergunta pergunta) {
//		try {
//			List<Jogador> jogadores = jogadorDAO.findByParameters(jogador);
//			return jogadores.get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
