package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {

	public static void main(String[] args) {
		// Criando uma instâcia de classe aula

		Aula a1 = new Aula("Revisitando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

		// Criando uma Arraylist de aulas
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);

		// Sobrescrevendo o método toString da classe aula para realizar a impressão
		// corretamente
		System.out.println(aulas);

		// Ordenando a lista de aulas
		// Para que possamos usar o método sort do Collections na nossa classe aula é
		// importante
		// que a mesma implemente a interface comparable e o método compareTo
		Collections.sort(aulas);
		System.out.println(aulas);

		// Definindo um outro método de ordenação diretamente na classe Collections.sort
		// Ordenando essa lista de acordo com o tempo de uma aula
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);

		// Uma outra forma de fazer é chamando o método sort diretamente da coleção e
		// passando o comparator
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

}
