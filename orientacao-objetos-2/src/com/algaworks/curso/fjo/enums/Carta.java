package com.algaworks.curso.fjo.enums;

public class Carta {

	private int numero;
	private Naipe naipe;
	
	// Metódo construtor da classe que vai receber o enum(Naipe) junto com o número da carta
	public Carta(int numero, Naipe naipe) {
		this.numero = numero;
		this.naipe = naipe;
	}
	
	public void imprimirCarta() {
		System.out.println("Sou " + numero + " de " + naipe + " e tenho a cor " + naipe.getCor());
	}
}
