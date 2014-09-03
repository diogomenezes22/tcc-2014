package br.edu.granbery.tcc.controller;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.view.GameControllerView;

@Named
@ViewScoped
public class GameController {
	
	@Inject
	GameControllerView view;
	
	@PostConstruct
	public void inicializar(){
		System.out.println("testando...........");
		System.out.println("1...........");
		System.out.println("2...........");
		System.out.println("3...........");
	}
	
	public int sortearDado(){
		Random r = new Random();
		
		return r.nextInt(6) + 1;
	}
}
