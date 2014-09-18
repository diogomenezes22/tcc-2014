package br.edu.granbery.tcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.model.Jogador;
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
	
	private boolean mostraPergunta;
	private boolean mostraPoPup;
	private boolean acertou;
	
	@PostConstruct
	public void load(){
		try{
		Jogador jogador1 = new Jogador();
		Jogador jogador2 = new Jogador();
		
		view.getJogo().setDataInicio(new Date());
		view.getJogo().setJogadores(new ArrayList<Jogador>());
		view.getJogo().getJogadores().add(jogador1);
		view.getJogo().getJogadores().add(jogador2);
		
		for (Jogador jogador : view.getJogo().getJogadores()) {
			
		}
		mostraPoPup = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void buscarPergunta(){
		//mock temporario para testes
		List<Resposta> respostas = new ArrayList<Resposta>();
		respostas.add(view.getR4());
		respostas.add(view.getR3());
		respostas.add(view.getR2());
		respostas.add(view.getR1());
		view.getPergunta().setDescricao("Qual a raiz quadrada de 4 ?");
		view.getPergunta().setRespostas(respostas);
		mostraPergunta = true;
	}
		
	public void responder(){
		Random r = new Random();
		int numeroSorteado = r.nextInt(6) + 1;
		if(verificaResposta(view.getRepostaEscolhida())){
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
		
	public boolean verificaResposta(String alternativa){
		
		
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
