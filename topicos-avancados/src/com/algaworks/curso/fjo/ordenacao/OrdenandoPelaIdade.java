package com.algaworks.curso.fjo.ordenacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenandoPelaIdade {

	public static void main(String[] args) {
		List<Pessoa> pessoas = Arrays.asList(new Pessoa("Celso", 37), new Pessoa("Aline", 39), new Pessoa("Cecilia", 65));
		
		// Usando a implementação do Comparator para também fazer o sort pela idade
		IdadeComparator idadeComparator = new IdadeComparator();
		
		// Ordenando a lista primeiro pelo nome depois pela idade
		
		// Substituido no Java 8 
		// Collections.sort(pessoas, idadeComparator);
		pessoas.sort(idadeComparator);
		
		// Substituido no Java 8 
		// for(Pessoa pessoa: pessoas) {
		//	System.out.println(pessoa);
		// }
		pessoas.forEach(System.out::println);
	}
}
