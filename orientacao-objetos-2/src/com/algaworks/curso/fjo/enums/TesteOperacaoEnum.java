package com.algaworks.curso.fjo.enums;

public class TesteOperacaoEnum {

	public static void main(String[] args) {
		OperacaoAritmetica o1 = OperacaoAritmetica.ADICAO;
		OperacaoAritmetica o2 = OperacaoAritmetica.SUBTRACAO;
		
		int resultado1 = o1.operacao(5, 3);
		System.out.println("O resultado da Adição: " + resultado1);
		
		int resultado2 = o2.operacao(8, 2);
		System.out.println("O resultado da Subtração: " + resultado2);
		
		// Podemos também percorrer um enum com o for como se fosse um array
		// os valores presentes no enum serão armazenados na variável oa
		for (OperacaoAritmetica oa : OperacaoAritmetica.values()) {
			System.out.println(oa + " -> " + oa.operacao(4, 2));
		}
	}

}
