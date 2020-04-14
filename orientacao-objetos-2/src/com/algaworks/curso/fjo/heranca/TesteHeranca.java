package com.algaworks.curso.fjo.heranca;

public class TesteHeranca {

	public static void main(String[] args) {
		// Os atributos nome e idade pertecem a classe pai Pessoa
		// mas via herança também estão disponíveis nos filhos
		Jogador jogador = new Jogador();
		jogador.nome = "Ronaldo Gaucho";
		jogador.idade = 37;
		
		// Os metódos definidos na classe pai também são herdados pelos filhos
		jogador.seApresentar();
		
		// Esse metódo está definido somente na classe jogador
		// é um metódo especifico desta classe
		jogador.dizerSeAindaJoga();

	}

}
