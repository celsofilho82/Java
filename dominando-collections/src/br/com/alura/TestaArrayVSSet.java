package br.com.alura;

import java.util.Collection;
import java.util.HashSet;

public class TestaArrayVSSet {

	public static void main(String[] args) {
		// Classe que testa performance, com um código que insere 50 mil números em uma
		// ArrayList e em um Set e os pesquisa. Vamos usar o método currentTimeMillis(),
		// de System, para cronometrar o tempo gasto com a adição e pesquisa dos
		// elementos:

		// Resultados:
		// ArrayList Tempo gasto: 1199
		// HashSet Tempo gasto: 30

		// Conclusões:
		// No caso do ArrayList, a inserção é bem rápida e a busca muito lenta!
		// No caso do HashSet, a inserção ainda é rápida, embora um pouco mais lenta do
		// que a das listas. Mas a busca é muito rápida!

		Collection<Integer> numeros = new HashSet<Integer>();

		long inicio = System.currentTimeMillis();

		for (int i = 1; i <= 50000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto: " + tempoDeExecucao);

	}

}
