package com.algaworks.curso.fjo.strings;

public class TesteStrings {

	public static void main(String[] args) {
		//String, Stringbuilder e StringBuffer
		
		// Neste exemplo são criadas duas strings já que uma string é imutável
		String s = "Olá"; // Criada a string "Olá"
		s = s + " pessoal!"; // Criada a string "Olá pessoal"
		System.out.println("String: " + s);
		
		// Neste exemplo criando uma StringBuilder que não é imutável economizando recursos
		// StringBuilder e StringBuffer possuem o mesmo comportamento, a difereça está relacionada a sistemas multithread.
		StringBuilder sb = new StringBuilder("Olá"); // Existe a StringBuilder "Olá"
		sb.append(" pessoal!"); // Reaproveitando a StringBuilder
		System.out.println("StringBuilder: "+ sb);
	}

}
