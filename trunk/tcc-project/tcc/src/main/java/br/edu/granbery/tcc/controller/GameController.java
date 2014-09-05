package br.edu.granbery.tcc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.model.Resposta;
import br.edu.granbery.tcc.view.GameControllerView;

@Named
@ViewScoped
public class GameController {
	
	@Inject
	private GameControllerView view;

	public void load(){
		this.view.setMostrarPergunta(false);
		//this.view.setVariavelTeste("Por que esta meerda não aparece na tela");
	}
	@PostConstruct
	public void buscarPergunta(){
		//mock temporario para testes
		this.view.setVariavelTeste("Por que esta buceta não aparece na tela");
		Resposta r1 = new Resposta();
		Resposta r2 = new Resposta();
		Resposta r3 = new Resposta();
		Resposta r4 = new Resposta();
		r1.setDescricao("Sim");
		r1.setCorreta(false);
		r2.setDescricao("Com certeza");
		r2.setCorreta(false);
		r3.setDescricao("óbvio");
		r3.setCorreta(false);
		r4.setDescricao("todas as alternativas anteriores");
		r4.setCorreta(true);
		List<Resposta> respostas = new ArrayList<Resposta>();
		respostas.add(r4);
		respostas.add(r3);
		respostas.add(r2);
		respostas.add(r1);
		this.view.getPergunta().setDescricao("O renato e gay ?");
		this.view.getPergunta().setRespostas(respostas);
		this.view.setMostrarPergunta(true);
	}
	
	public GameControllerView getView() {
		return view;
	}
	
	public void setView(GameControllerView view) {
		this.view = view;
	}
}
