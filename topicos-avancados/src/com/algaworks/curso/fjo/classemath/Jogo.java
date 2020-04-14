package com.algaworks.curso.fjo.classemath;

public class Jogo {

	private int quantidadeJogos;
	
	public Jogo(int quantidadeJogos) {
		this.quantidadeJogos = quantidadeJogos;
	}

	public void gerarNumeros() {
		for(int i = 1; i <= quantidadeJogos; i++) {
			int valor;
			System.out.println("Jogo " + i);
			System.out.print("Números: ");
			for(int j = 0; j < 6; j++) {
				valor = (int) (Math.random() * 61);
				System.out.print(valor + ", ");
			}
			System.out.println();
		}
	}
}

