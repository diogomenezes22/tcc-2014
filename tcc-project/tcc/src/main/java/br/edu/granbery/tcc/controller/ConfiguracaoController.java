package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PeaoManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Peao;
import br.edu.granbery.tcc.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ConfiguracaoController implements Serializable {

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
	public void load() {
		peaoManager.limparJogo();
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

	public void associarJogadorPeao(Jogador jogador) {
		if (peaoEscolhido != null && peaoEscolhido.getId() != null) {
			if (listaPeoesUtilizados.contains(peaoEscolhido)) {
				for (Peao peao : listaPeoesUtilizados) {
					if (peao.equals(peaoEscolhido)) {
						peao.setJogador(jogador);
					}
				}
			}else {
				peaoEscolhido.setJogador(jogador);
				listaPeoesUtilizados.add(peaoEscolhido);
			}
		} else {
			for (Peao peao : listaPeoesUtilizados) {
				if (peao.getJogador().equals(jogador)) {
					peao.setJogador(null);
					listaPeao.add(peao);
					listaPeoesUtilizados.remove(peao);
				}
			}
		}
	}

	public String salvarConfiguracoes() {
		if (listaPeoesUtilizados.size() > 0) {
			for (Peao peao : listaPeoesUtilizados) {
				peaoManager.salvar(peao);
			}
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().remove("configuracaoController");
			return "../game/game.jsf?faces-redirect=true";
		} else {
			FacesUtil.mostrarMensagemAlerta("erro.escolha.um.Jogador");
			return null;
		}
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
