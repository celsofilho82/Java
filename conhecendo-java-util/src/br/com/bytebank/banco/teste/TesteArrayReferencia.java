package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayReferencia {

	public static void main(String[] args) {
		
		// Criando um array para armazenar objetos
		ContaCorrente[] contas = new ContaCorrente[5];
		
		// Criando um objeto
		ContaCorrente cc1 = new ContaCorrente(1438, 390062);
		
		// Armazenando a referência para o objeto no array
		contas[0] = cc1;
		
		// Acessando os métodos do objeto usando a referência no array
		System.out.println(contas[0].getAgencia());
		
	}

}
