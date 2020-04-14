package com.algaworks.curso.fjo.enums;

public class TesteEnum {

	public static void main(String[] args) {
		// Criando uma carta do baralho usando o enum e a classe carta
		Carta quatroPaus = new Carta(4, Naipe.PAUS);
		quatroPaus.imprimirCarta();
		
		// Percorrendo o enum Cartas usando um for
		for (Naipe n : Naipe.values()) {
			System.out.println(n + " -> " + n.getCor());
		}

	}

}
