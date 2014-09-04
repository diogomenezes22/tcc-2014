package br.edu.granbery.tcc.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.granbery.tcc.view.GameControllerView;

@Named
@SessionScoped
public class GameController {
	
	@Inject
	public GameControllerView view;
	
	@PostConstruct
	public void load(){
		System.out.println("testando...........");
		System.out.println("1...........");
		System.out.println("2...........");
		System.out.println("3...........");
	}
	
	public String sortearDado(){
		System.out.println("Chupa!!!");
		return "/game.xhtml";
	}
}
