package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteToString {

	public static void main(String[] args) {
		// Sobrescrevendo o método toString herdados da classe Object
		
		ContaCorrente cc = new ContaCorrente(123, 456);
		ContaPoupanca cp = new ContaPoupanca(789, 101);
		
		// Usando o método toString para imprimir os objetos
		// esse método foi sobreescrito nas classes
		System.out.println(cc);
		System.out.println(cp);
		

	}

}
