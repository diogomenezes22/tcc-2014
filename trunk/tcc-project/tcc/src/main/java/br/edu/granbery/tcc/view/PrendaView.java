package br.edu.granbery.tcc.view;

import javax.inject.Named;

import br.edu.granbery.tcc.model.Prenda;


@Named
public class PrendaView {
	private Prenda prenda = new Prenda();

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}


}
