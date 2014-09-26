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
		listaPeao.remove(peaoEscolhido);
		peaoEscolhido.setJogador(jogador);
		listaPeoesUtilizados.add(peaoEscolhido);
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

	public List<Peao> getListaPeoesUtilizados() {
		return listaPeoesUtilizados;
	}

	public void setListaPeoesUtilizados(List<Peao> listaPeoesUtilizados) {
		this.listaPeoesUtilizados = listaPeoesUtilizados;
	}

}
