package com.algaworks.curso.fjo.modificadorstatic;

public class TesteContador {

	public static void main(String[] args) {
		// Acessand um atributo statico da classe contador
		Contador.count++;
		
		int valorDoCount = Contador.count;
		System.out.println("Valor: " + valorDoCount);
		
		// Chamando o metódo da classe static
		Contador.imprimirContador();
	}

}
