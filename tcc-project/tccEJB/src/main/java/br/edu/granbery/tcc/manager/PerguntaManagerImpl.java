package br.edu.granbery.tcc.manager;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

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
					if(!StringUtils.isEmpty(resp.getDescricao())){
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
