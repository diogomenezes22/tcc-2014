package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.JogadorManager;
import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.model.Jogador;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;
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
	
	
	
	private boolean mostraPergunta;
	private boolean mostraPoPup;
	private boolean acertou;
	
	@PostConstruct
	public void load(){
		try{
		view.getJogo().setJogadores(jogadorManager.buscarTodos());
		
		mostraPoPup = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void buscarPergunta(){
		Pergunta pergunta = perguntaManager.buscarPerguntaAleatoria();
		view.getPergunta().setDescricao(pergunta.getDescricao());
		view.getPergunta().setRespostas(pergunta.getRespostas());
		mostraPergunta = true;
	}
		
	public void responder(){
		Random r = new Random();
		int numeroSorteado = r.nextInt(6) + 1;
		if(verificaResposta()){
			acertou = true;
			preencherCamposHidden(view.getJogadorAtual());
		}else{
			acertou = false;
		}
		mostraPoPup = true;
		mostraPergunta = false;
	}
	

	public void passaVez(){
		for(int i = 0; i < view.getJogo().getJogadores().size(); i++){
			
		}
		
		mostraPergunta = false;
		mostraPoPup = false;
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
		view.setNome(jogadorAtual.getNome());
	}
	
	
	private void verificaFimJogo(Jogador jogador){
		
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
