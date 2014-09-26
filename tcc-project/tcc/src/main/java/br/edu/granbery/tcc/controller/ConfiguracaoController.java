package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PeaoManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Peao;

@Named
@RequestScoped
public class ConfiguracaoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Jogador> listaJogador;
	private List<Peao> listaPeao;
	private Long idPeaoEscolhido;
	
	@Inject
	private JogadorManager jogagorManager;
	@Inject
	private PeaoManager peaoManager;
	
	
	@PostConstruct
	public void load(){
		listaJogador = jogagorManager.buscarTodos();
		listaPeao = peaoManager.buscarTodos();
		
	}

	public List<Jogador> getListaJogador() {
		return listaJogador;
	}

	public void setListaJogador(List<Jogador> listaJogador) {
		this.listaJogador = listaJogador;
	}

	public List<Peao> getListaPeao() {
		return listaPeao;
	}

	public void setListaPeao(List<Peao> listaPeao) {
		this.listaPeao = listaPeao;
	}

	public Long getIdPeaoEscolhido() {
		return idPeaoEscolhido;
	}

	public void setIdPeaoEscolhido(Long idPeaoEscolhido) {
		this.idPeaoEscolhido = idPeaoEscolhido;
	}
}
