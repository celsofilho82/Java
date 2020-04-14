package com.algaworks.curso.fjo.sobrecarga;

public class TesteCadastro {

	public static void main(String[] args) {
		CadastroPessoa cadastro = new CadastroPessoa();
		
		Pessoa pessoa = new Pessoa("Celso Ribeiro", 37);
		
		// Usando o 1º método cadastrar que recebe um objeto como parâmetro
		cadastro.cadastrar(pessoa);
		
		// Usando o 2º método cadastrar que recebe 2 parâmetros 
		cadastro.cadastrar("Aline Sousa", 39);
	}
}
