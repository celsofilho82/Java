package com.algaworks.curso.fjo.heranca;

public class Pessoa {

	// Com o modificador de acesso protected dizemos que esses atributos estão
	// disponíveis para classes do mesmo pacote ou que herdam desta classe.
	protected String nome;
	protected int idade;
	
	public void seApresentar() {
		System.out.println("Olá, eu sou o " + nome + " e tenho " + idade + " anos");
	}
}
