package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Informando para o spring que éssa classe é um controller
@Controller 
public class HomeController {
	
	// Criando uma rota para a raiz
	@RequestMapping("/")
	public String index() {
		System.out.println("Entrando na home da casa do código");
		return "home";
	}
	
}
