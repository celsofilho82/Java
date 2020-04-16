package com.algaworks.curso.fjo.excecoes;

// Para criarmos uma exceção, precisamos herdar da classe exception
// Toda classe que herda da classe exception é uma exceção checada
// Precisamos informar na assinatura do método em que vamos utilizar uma exceção checada

public class SaldoInsuficienteException extends Exception{
	
	public SaldoInsuficienteException(String mensagem) {
		// Chamando o construtor da classe exception passando a mensagem
		super(mensagem);
	}

}
