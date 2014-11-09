package br.edu.granbery.tcc.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import br.edu.granbery.tcc.manager.PrendaManager;
import br.edu.granbery.tcc.model.Prenda;
import br.edu.granbery.tcc.view.PrendaView;

@ViewScoped
@ManagedBean(name="prendaController")
public class PrendaController {
	
	@Inject
	private PrendaView view;
	
	@Inject
	PrendaManager prendaManager;
	
	private List<Prenda> prendas;
	private Prenda prenda;
			
	@PostConstruct
	public void load(){
	}
	
	public String salvar(){
		prendaManager.salvar(view.getPrenda());
		return "/prenda/listarPrenda.jsf";
	}
	
	public String alterar(){
		prendaManager.alterar(this.view.getPrenda());
		return "/prenda/listarPrenda.jsf";
	}
	
	public void excluir(Prenda prenda){
		prendaManager.excluir(prenda);
	}
	public String editar(Prenda p){
		view.setPrenda(p);
		return "/prenda/alterar.jsf";
	}

	public PrendaView getView() {
		return view;
	}

	public void setView(PrendaView view) {
		this.view = view;
	}

	public List<Prenda> getPrendas() {
		prendas = prendaManager.recuperarPrendas();
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	

}
