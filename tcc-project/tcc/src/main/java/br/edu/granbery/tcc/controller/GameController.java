package br.edu.granbery.tcc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PeaoManager;
import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Jogo;
import br.edu.granbery.tcc.model.Peao;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;
import br.edu.granbery.tcc.model.Tabuleiro;
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
	@Inject
	private JogadorManager jogadorManager;
	@Inject
	private PerguntaManager perguntaManager;
	@Inject
	private PeaoManager peaoManager;
	
	
	private boolean mostraPergunta;
	private boolean mostraPoPup;
	private boolean acertou;
	
	
	public GameController(){
		
	}
	
	@PostConstruct
	public void load(){
		try{			
		view.setJogo(new Jogo(new Tabuleiro(), jogadorManager.buscarQuemVaiJogar()));
		view.setListaPeoes(peaoManager.buscarPeoesEmJogo());
		view.setJogadorAtual(view.getJogo().getJogadores().get(0));
		view.setPeaoEmJogo(colocarPeaoEmJogo(view.getJogadorAtual()));
		mostraPoPup = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void buscarPergunta(){
		Pergunta pergunta = new Pergunta();
		do{
			pergunta = perguntaManager.buscarPerguntaAleatoria();		
		}while(view.getJogo().getPerguntas().contains(pergunta));
		view.setPergunta(pergunta);
		mostraPergunta = true;
	}
		
	public void responder(){
		if(verificaResposta()){
			acertou = true;
			view.getJogo().getPerguntas().add(view.getPergunta());
			preencherCamposHidden(view.getJogadorAtual());
			Jogador proximoJogador = view.getJogo().passaVez(view.getJogadorAtual());
			view.setJogadorAtual(proximoJogador);
			view.setPeaoEmJogo(colocarPeaoEmJogo(proximoJogador));
		}else{
			acertou = false;
			preencherCamposHidden(view.getJogadorAtual());
			Jogador proximoJogador = view.getJogo().passaVez(view.getJogadorAtual());
			view.setJogadorAtual(proximoJogador);
			view.setPeaoEmJogo(colocarPeaoEmJogo(proximoJogador));
		}
		mostraPoPup = true;
		mostraPergunta = false;
	}
		
	public boolean verificaResposta(){
		for(Resposta resposta :view.getPergunta().getRespostas()){
			if(view.getRepostaEscolhida().equals(resposta.getId().toString())){
				return resposta.isCorreta();
			}
		}
		
		return false;
	}
	
	private void preencherCamposHidden(Jogador jogadorAtual) {
		for (Peao peao : view.getListaPeoes()) {
			if(peao.getJogador().getId().equals(jogadorAtual.getId())){
				view.setPeaoEmJogo(peao);
			}
		}
		
	}
	
	private Peao colocarPeaoEmJogo(Jogador jogadorAtual){
		for(Peao peao :view.getListaPeoes()){
			if(peao.getJogador().equals(jogadorAtual))
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


	public boolean isMostraPoPup() {
		return mostraPoPup;
	}


	public void setMostraPoPup(boolean mostraPoPup) {
		this.mostraPoPup = mostraPoPup;
	}


	public boolean isAcertou() {
		return acertou;
	}


	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}
}
