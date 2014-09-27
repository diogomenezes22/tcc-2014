package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PeaoManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Peao;

@Named
@SessionScoped
public class ConfiguracaoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Jogador> listaJogador;
	private List<Peao> listaPeao;
	private List<Peao> listaPeoesUtilizados;
	private Peao peaoEscolhido;
	
	@Inject
	private JogadorManager jogagorManager;
	@Inject
	private PeaoManager peaoManager;
	
	
	@PostConstruct
	public void load(){
		listaJogador = jogagorManager.buscarTodos();
		listaPeao = peaoManager.buscarTodos();
		listaPeoesUtilizados = new ArrayList<Peao>();
	}

	public List<Jogador> getListaJogador() {
		return listaJogador;
	}

	public void setListaJogador(List<Jogador> listaJogador) {
		this.listaJogador = listaJogador;
	}
	
	public void associarJogadorPeao(Jogador jogador){
		if(peaoEscolhido != null){
			listaPeao.remove(peaoEscolhido);
			peaoEscolhido.setJogador(jogador);
			listaPeoesUtilizados.add(peaoEscolhido);
		}else{
			for (Peao peao : listaPeoesUtilizados) {
				if(peao.getJogador().equals(jogador)){
					peao.setJogador(null);
					listaPeao.add(peao);
					listaPeoesUtilizados.remove(peao);
				}
			}
		}
	}
	
	public String salvarConfiguracoes(){
		for (Peao peao : listaPeoesUtilizados) {
			peaoManager.salvar(peao);
		}
		
		return "game.jsf";
	}
	
	public List<Peao> getListaPeao() {
		return listaPeao;
	}

	public void setListaPeao(List<Peao> listaPeao) {
		this.listaPeao = listaPeao;
	}

	public Peao getPeaoEscolhido() {
		return peaoEscolhido;
	}

	public void setPeaoEscolhido(Peao peaoEscolhido) {
		this.peaoEscolhido = peaoEscolhido;
	}

	public List<Peao> getListaPeoesUtilizados() {
		return listaPeoesUtilizados;
	}

	public void setListaPeoesUtilizados(List<Peao> listaPeoesUtilizados) {
		this.listaPeoesUtilizados = listaPeoesUtilizados;
	}

}
