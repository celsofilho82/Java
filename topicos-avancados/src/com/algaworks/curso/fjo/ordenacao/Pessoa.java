package com.algaworks.curso.fjo.ordenacao;

public class Pessoa implements Comparable<Pessoa>{

	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}

	@Override
	// Para que ocorra a ordenação a classe deve implementar a interface Comparable e o methodo compareTo
	// Quando retorna "-1" indica que o objeto atual deve vir antes do objeto passado
	// Quando retorna "1" o objeto atual deve vir depois
	// Quando retrona "0" os dois são iguais
	
	public int compareTo(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return this.nome.compareTo(pessoa.getNome());
	}
	
}


