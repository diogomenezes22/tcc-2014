package br.edu.granbery.tcc.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Prenda;
import br.edu.granbery.tcc.view.JogadorView;

@ViewScoped
@ManagedBean(name="jogadorController")
public class JogadorController {
	
	@Inject
	private JogadorView view;
	
	@Inject
	JogadorManager jogadorManager;
	
	private List<Jogador> jogadores;
	
	@PostConstruct
	public void load(){
		
	}
	
	public String salvar(){
		if(validaJogador()){
			jogadorManager.salvar(view.getJogador());
			return "/jogador/listarJogador.jsf";
		}
		return "";
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
	
	public void excluir(Jogador jogador){
		jogadorManager.excluir(jogador);
	}
	
	public String editar(Jogador j){
		view.setJogador(j);
		return "/jogador/alterar.jsf";
	}
	
	public String alterar(){
		jogadorManager.alterar(this.view.getJogador());
		return "/jogador/listarJogador.jsf";
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

	public List<Jogador> getJogadores() {
		jogadores =  jogadorManager.buscarTodos();
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
