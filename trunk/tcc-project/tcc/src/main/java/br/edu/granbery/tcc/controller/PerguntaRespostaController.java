package br.edu.granbery.tcc.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.manager.PerguntaManager;
import br.edu.granbery.tcc.model.Pergunta;
import br.edu.granbery.tcc.model.Resposta;

@Named
@RequestScoped
public class PerguntaRespostaController {
	
	private Pergunta pergunta;
	private List<Pergunta> perguntas;
	private Integer opcaoCorreta = -1;
	private int pagina = 2;
	
	@Inject
	PerguntaManager perguntaManager;
	
	@PostConstruct
	public void load(){
		pergunta = new Pergunta();
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	public String salvar(){
		String mensagemErro = "";
		if(validaPergunta(mensagemErro)){
		pergunta.getRespostas().get(opcaoCorreta).setCorreta("C");
		perguntaManager.salvar(pergunta);
		pergunta = new Pergunta();
		return "salvo";
		}
		return mensagemErro;
	}
	
	private boolean validaPergunta(String mensagemErro) {
		if("".equals(pergunta.getDescricao())){
			mensagemErro ="A Pergunta não pode ser vazia!";
			return false;
		}
		if(opcaoCorreta ==-1){
			mensagemErro ="Favor marcar qual das opções está correta!";
			return false;
		}
		for (Resposta resp : pergunta.getRespostas()) {
			if("".equals(resp.getDescricao())){
				mensagemErro = "Todas as Respostas devem ser preenchidas!";
				return false;
			}
		}
		return true;
	}

	public void buscar(){
		setPerguntas(perguntaManager.consultar(pergunta));		
		return ;
	}
	

	public int getOpcaoCorreta() {
		return opcaoCorreta;
	}

	public void setOpcaoCorreta(int opcaoCorreta) {
		this.opcaoCorreta = opcaoCorreta;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void editaPergunta(){
		
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

}
