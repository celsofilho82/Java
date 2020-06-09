package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		// Começando a utilizar um Array

		String aula1 = "Conheçendo mais de listas";
		String aula2 = "Modelando a classe Aula";
		String aula3 = "Trabalhando com Cursos e Sets";

		// Criando uma ArrayList
		ArrayList<String> aulas = new ArrayList<String>();

		// Adicionando elementos numa ArrayList
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		System.out.println(aulas);

		// Removendo elementos de uma ArrayList
		aulas.remove(0);
		System.out.println(aulas);

		// Fazendo um ForEach na coleção
		// Lê-se: para cada String aula dentro de aulas:
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}

		// Obtendo os elementos com o método get()
		String primeiraAula = aulas.get(0);
		System.out.println(primeiraAula);

		// Percorrendo uma lista através do seu indice
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("aula : " + aulas.get(i));
		}

		// Usando o método for das coleções e passando um lambda
		// lê-se: para cada aula dentro da coleção aulas, faça o seguinte:
		aulas.forEach(aula -> {
			System.out.println("percorrendo: " + aula);
		});
		
		// Ordenando uma lista utilizando a classe Collections e seu método
		// statico sort
		String aula4 = "Aumentando o nosso conhecimento";
		aulas.add(aula4);
		Collections.sort(aulas);
		System.out.println(aulas);
	}

}
