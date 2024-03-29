package br.edu.granbery.tcc.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PeaoManager;
import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.manager.PrendaManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Jogo;
import br.edu.granbery.tcc.model.Peao;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;
import br.edu.granbery.tcc.model.Tabuleiro;
import br.edu.granbery.tcc.util.FacesUtil;
import br.edu.granbery.tcc.view.GameControllerView;

@ManagedBean
@ViewScoped
public class GameController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GameControllerView view;
	@Inject
	private JogadorManager jogadorManager;
	@Inject
	private PerguntaManager perguntaManager;
	@Inject
	private PeaoManager peaoManager;
	@Inject
	private PrendaManager prendaManager;
	

	private boolean mostraPergunta;
	private boolean mostrarPrenda;
	private boolean acertou;
	private Jogo jogo;

	public GameController() {

	}

	@PostConstruct
	public void load() {
		try {
			setJogo(new Jogo(new Tabuleiro(),
			jogadorManager.buscarQuemVaiJogar()));
			view.setListaPeoes(peaoManager.buscarPeoesEmJogo());
			view.setJogadorAtual(getJogo().getJogadores().get(0));
			view.setPeaoEmJogo(colocarPeaoEmJogo(view.getJogadorAtual()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buscarPergunta() {
		mostrarPrenda = false;
		Pergunta pergunta = new Pergunta();
		do {
			pergunta = perguntaManager.buscarPerguntaAleatoria();
		} while (getJogo().getPerguntas().contains(pergunta));
		view.setPergunta(pergunta);
		view.setPeaoEmJogo(colocarPeaoEmJogo(view.getJogadorAtual()));
		mostraPergunta = true;
	}

	public void responder() {
		if (verificaResposta()) {
			acertou = true;
			getJogo().getPerguntas().add(view.getPergunta());
			view.setPeaoEmJogo(colocarPeaoEmJogo(view.getJogadorAtual()));
			if(getJogo().mover(view.getPeaoEmJogo().getJogador(), Integer.parseInt(view.getNumeroSorteado()))){
				//fim do jogo	
				try {
					ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
					ex.getFlash().put("vencedor", view.getJogadorAtual().getNome());
					ex.redirect("fimJogo.jsf");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if("PR".equals(getJogo().getTipoCasa(view.getPeaoEmJogo().getJogador()))){
				mostrarPrenda = true;
				view.setPrenda(prendaManager.buscarPrendaAleatoria());				
			}
			
			view.getPeaoEmJogo().setPodeAndar(true);
			view.getPeaoEmJogo().setPosicaoAtual(view.getPeaoEmJogo().getProximaPosicao());
			view.getPeaoEmJogo().setProximaPosicao(view.getPeaoEmJogo().getPosicaoAtual() + Integer.parseInt(view.getNumeroSorteado()));
			Jogador proximoJogador = getJogo().passaVez(view.getJogadorAtual());
			view.setJogadorAtual(proximoJogador);
			FacesUtil.mostrarMensagemSucesso("game.resposta.correta");
		} else {
			acertou = false;
			view.setPeaoEmJogo(colocarPeaoEmJogo(view.getJogadorAtual()));
			view.getPeaoEmJogo().setPodeAndar(false);
			Jogador proximoJogador = getJogo().passaVez(view.getJogadorAtual());
			view.setJogadorAtual(proximoJogador);
			FacesUtil.mostrarMensagemErro("game.resposta.errada");
		}
		mostraPergunta = false;
	}

	public boolean verificaResposta() {
		for (Resposta resposta : view.getPergunta().getRespostas()) {
			if (Long.parseLong(view.getRepostaEscolhida()) == resposta.getId()) {
				return resposta.isCorreta();
			}
		}
		return false;
	}

	private Peao colocarPeaoEmJogo(Jogador jogadorAtual) {
		for (Peao peao : view.getListaPeoes()) {
			if (peao.getJogador().equals(jogadorAtual))
				return peao;
		}
		return null;
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

	public boolean isAcertou() {
		return acertou;
	}

	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public boolean isMostrarPrenda() {
		return mostrarPrenda;
	}

	public void setMostrarPrenda(boolean mostrarPrenda) {
		this.mostrarPrenda = mostrarPrenda;
	}
}
