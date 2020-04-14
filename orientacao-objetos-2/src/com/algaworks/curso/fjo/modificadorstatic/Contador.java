package com.algaworks.curso.fjo.modificadorstatic;

public class Contador {

	// Ao definir um atributo como statico "static" o mesmo passa a pertencer a classe 
	// e é compartilhado por todos os objetos gerados por está classe.
	public static int count = 0;
	
	// Para definir uma variável constante utilizamos a palavra reservador "final" na definição do atributo
	public static final double PI = 3.14;
	
	// Definindo um metódo de classe "static"
	
	public static void imprimirContador() {
		System.out.println("O valor do contador é: " + count);
	}
}

