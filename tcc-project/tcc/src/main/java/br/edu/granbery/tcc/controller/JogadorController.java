package br.edu.granbery.tcc.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.view.JogadorView;

@Named
@RequestScoped
public class JogadorController {
	
	@Inject
	private JogadorView view;
	
	@Inject
	JogadorManager jogadorManager;
	
	@PostConstruct
	public void load(){
		
	}
	
	public String salvar(){
		if(validaJogador())
		jogadorManager.salvar(view.getJogador());
		return "Salvo";
	}	
	
	public String buscar(){
		Jogador jog = jogadorManager.consultar(view.getJogador());
		view.setJogador(jog);		
		return "Buscado";
	}
	
	public String deletar(){
		Jogador jog = jogadorManager.consultar(view.getJogador());
		view.setJogador(jog);		
		return "ok";
	}

	private boolean validaJogador() {
		Jogador jog = view.getJogador();		
		return true;
	}

	public JogadorView getView() {
		return view;
	}

	public void setView(JogadorView view) {
		this.view = view;
	}

}
