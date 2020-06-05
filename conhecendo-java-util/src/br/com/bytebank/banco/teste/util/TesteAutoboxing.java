package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteAutoboxing {

	public static void main(String[] args) {
		
		// Existe uma classe(Wrapper) que representa cada tipo primitivo em Java para funcionar com coleções
		// int -----------> (Autoboxing) java.lang.Integer
		// int <----------- (Unboxing) java.lang.Integer
		
		// Colocando valores primitivos em Arraylist que guarda somente referências
		
		// O ArrayList só armazena referências de objetos mas com o autoboxing é possível
		// também armazenar dados primitivos
		
		int idade = 29;
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(idade); // isso só é possível por causa do autoboxing
		
		// Usando um Wrapper com o método valueOf para criar um objeto apartir do primitivo
		Integer idadeRef = Integer.valueOf(29);
		
		// Obtendo o primitivo apartir do Objeto Unboxing
		int valor = idadeRef.intValue();
		
		// Transformando uma string em integer(Parsing) de formas diferentes
		String s = "10";
		// Integer numero = Integer.valueOf(s);
		int numero = Integer.parseInt(s);
		
		System.out.println(numero);
		
		Integer ref = Integer.valueOf("3");
        ref++; // Ocorre um autoboxing nesta linha
		       // int valor = ref.intValue();
		       // valor = valor + 1;
		       // ref = Integer.valueOf(valor);
        System.out.println(ref);
	}

}
