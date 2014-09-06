package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.model.Resposta;
import br.edu.granbery.tcc.view.GameControllerView;

@Named
@SessionScoped
public class GameController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GameControllerView view;
	
	private boolean mostraPergunta;
	
	@PostConstruct
	public void load(){
	
	}
	
	
	public void buscarPergunta(){
		//mock temporario para testes
		view.getR1().setDescricao("1");
		view.getR1().setAlternativa('A');
		view.getR1().setCorreta(false);
		view.getR2().setDescricao("2");
		view.getR2().setAlternativa('B');
		view.getR2().setCorreta(true);
		view.getR3().setDescricao("3");
		view.getR3().setAlternativa('C');
		view.getR3().setCorreta(false);
		view.getR4().setDescricao("34");
		view.getR4().setAlternativa('D');
		view.getR4().setCorreta(false);
		List<Resposta> respostas = new ArrayList<Resposta>();
		respostas.add(view.getR4());
		respostas.add(view.getR3());
		respostas.add(view.getR2());
		respostas.add(view.getR1());
		view.getPergunta().setDescricao("Qual a raiz quadrada de 499 ?");
		view.getPergunta().setRespostas(respostas);
		mostraPergunta = true;
	}
	
	public GameControllerView getView() {
		return view;
	}
	
	public void setView(GameControllerView view) {
		this.view = view;
	}


	public boolean isMostraPergunta() {
		return mostraPergunta;
	}


	public void setMostraPergunta(boolean mostraPergunta) {
		this.mostraPergunta = mostraPergunta;
	}
}
