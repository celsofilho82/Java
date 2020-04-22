package com.algaworks.curso.fjo.ordenacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenandoPeloNome {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Arrays.asList(new Pessoa("Celso", 37), new Pessoa("Aline", 39), new Pessoa("Cecilia", 65));
			
		// A classe deve implementar a interface Comparable e os métodos definidos nela.
		Collections.sort(pessoas); 
		
		for(Pessoa pessoa: pessoas) {
			System.out.println(pessoa);
		}
	}

}
