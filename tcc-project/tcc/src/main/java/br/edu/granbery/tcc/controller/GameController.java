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

import br.edu.granbery.model.Jogador;
import br.edu.granbery.model.Resposta;
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
		jogador1.setId(1);
		jogador1.setNome("Jão");
		jogador1.setVez(true);
		jogador1.setPosicaoAtual(0);
		jogador1.setProximaPosicao(0);
		jogador1.setPodeAndar(false);
		jogador2.setId(2);
		jogador2.setNome("Zé");
		jogador2.setVez(false);
		jogador2.setPosicaoAtual(0);
		jogador2.setPodeAndar(false);
		jogador2.setProximaPosicao(0);
		
		view.getJogo().setDataInicio(new Date());
		view.getJogo().setJogadores(new ArrayList<Jogador>());
		view.getJogo().getJogadores().add(jogador1);
		view.getJogo().getJogadores().add(jogador2);
		
		for (Jogador jogador : view.getJogo().getJogadores()) {
			if(jogador.isVez()){
				view.setJogadorAtual(jogador);
			}
		}
		mostraPoPup = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void buscarPergunta(){
		//mock temporario para testes
		view.getR1().setDescricao("1");
		view.getR1().setAlternativa("A");
		view.getR1().setCorreta(false);
		view.getR2().setDescricao("2");
		view.getR2().setAlternativa("B");
		view.getR2().setCorreta(true);
		view.getR3().setDescricao("3");
		view.getR3().setAlternativa("C");
		view.getR3().setCorreta(false);
		view.getR4().setDescricao("4");
		view.getR4().setAlternativa("D");
		view.getR4().setCorreta(false);
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
			view.getJogadorAtual().setPodeAndar(true);
			view.getJogadorAtual().setProximaPosicao(view.getJogadorAtual().getPosicaoAtual() + numeroSorteado);
			preencherCamposHidden(view.getJogadorAtual());
		}else{
			acertou = false;
		}
		mostraPoPup = true;
		mostraPergunta = false;
	}
	
	private void preencherCamposHidden(Jogador jogadorAtual) {
		view.setIdJogador(jogadorAtual.getId());
		view.setNome(jogadorAtual.getNome());
		view.setPodeAndar(jogadorAtual.isPodeAndar());
		view.setPosicaoAtual(jogadorAtual.getPosicaoAtual());
		view.setProximaPosicao(jogadorAtual.getProximaPosicao());	
	}

	public void passaVez(){
		for(int i = 0; i < view.getJogo().getJogadores().size(); i++){
			if(view.getJogo().getJogadores().get(i).isVez()){
				view.getJogo().getJogadores().get(i).setVez(false);
				view.getJogo().getJogadores().get(i).setPosicaoAtual(view.getJogo().getJogadores().get(i).getProximaPosicao());
				if(i + 1 >= view.getJogo().getJogadores().size()){
					view.getJogo().getJogadores().get(0).setVez(true);
					view.setJogadorAtual(view.getJogo().getJogadores().get(0));
				}else{
					view.getJogo().getJogadores().get(i+1).setVez(true);
					view.setJogadorAtual(view.getJogo().getJogadores().get(i+1));
				}
			}
		}
		
		mostraPergunta = false;
		mostraPoPup = false;
	}
		
	public boolean verificaResposta(String alternativa){
		
		if(alternativa.equals(view.getR1().getAlternativa())){
			return view.getR1().isCorreta();

		}else if(alternativa.equals(view.getR2().getAlternativa())){
			return view.getR2().isCorreta();

		}else if(alternativa.equals(view.getR3().getAlternativa())){
			return view.getR3().isCorreta();

		}else if(alternativa.equals(view.getR4().getAlternativa())){
			return view.getR4().isCorreta();

		}
		return false;
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
