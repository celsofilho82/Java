package com.algaworks.curso.fjo.animal;

public class Cachorro {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	// para usar este metódo em um outro pacote, é necessário alterar o modificador deste para público.
	public void sentar() {
		System.out.println("Eu " + nome + ", vou sentar!");
	}
}
