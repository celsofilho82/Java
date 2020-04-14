package com.algaworks.curso.fjo.enums;

public enum Naipe {

	// Enums são utilizados para declarar valores constantes.
	// Exemplo com os naipes do baralho
	
	OURO("Vermelho"),
	PAUS("Preto"),
	ESPADA("Preto"),
	COPAS("Vermelho");
	
	// Metódo construtor que vai definir uma cor para cada Naipe
	Naipe(String cor){
		this.cor = cor;
	}
	// Atributo cor da classe enum Naipe
	// é uma variável cor para cada naipe do baralho
	private String cor;
	
	// Metódo que vai obter a cor de cada um dos naipes do baralho
	public String getCor() {
		return cor;
	}
}
