package com.algaworks.curso.fjo.heranca;

// Aplicando a herança. A classe jogador herda de Pessoa
// Usamos a palavra reservadoa extends
public class Jogador extends Pessoa {
	
	protected boolean aindaJoga = false;
	
	public void dizerSeAindaJoga() {
		System.out.println("Ainda joga? " + aindaJoga);
	}
}
