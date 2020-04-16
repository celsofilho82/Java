package com.algaworks.curso.fjo.excecoes;

public class TesteExcecoes {
	
	public static void main(String[] args) {
		// Exemplo de exceção divisão por 0
		 int numero = 5 / 0; // java.lang.ArithmeticException: / by zero
		
		
		// Exemplo de exceção null pointer
		 String s = "Um texto";
		 s = null;
		 String maiuscula = s.toUpperCase(); // java.lang.NullPointerException
		
		// Criando suas próprias exceções
		ContaCorrente cc = new ContaCorrente(100);
		cc.depositar(-10); // java.lang.IllegalArgumentException: O valor não pode ser menor que 0
		
		// Capturando exceções com o bloco try -> catch
		
		try {
			cc.depositar(-10);
		} catch(IllegalArgumentException exception){
			System.out.println("Você executou uma operação ilegal: " + exception.getMessage() );
			// Você executou uma operação ilegal: O valor não pode ser menor que 0
		}
	}

}
