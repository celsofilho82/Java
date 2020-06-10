package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaOrdenacao {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as Coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

		// O melhor jeito de ordenar uma unmodifiable list seguindo algum critério é nos
		// aproveitarmos da possibilidade de poder passar a unmodifiable list no
		// construtor de uma ArrayList tradicional , podendo assim utilizar o método
		// .sort() de Collections.

		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);

		List<Aula> aulas = new ArrayList<Aula>(aulasImutaveis);
		Collections.sort(aulas);
		System.out.println(aulas);

		// Obtendo o tempo total de aulas do curso
		System.out.println(javaColecoes.getTempoTotal());

		// Imprimindo informações sobre o curso
		System.out.println(javaColecoes);

	}

}
