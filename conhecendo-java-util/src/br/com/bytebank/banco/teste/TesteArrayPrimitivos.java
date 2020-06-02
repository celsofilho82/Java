package br.com.bytebank.banco.teste;

public class TesteArrayPrimitivos {

	public static void main(String[] args) {
		// Array []
		
		// Inicializando um Array com 5 posições
		int[] idades = new int[5]; // inicializa cada posição com o valor padrão da classe int = 0
		
		// Acessando a posição 0 do array
		int idade1 = idades[0];
		System.out.println(idade1);
		
		// Atribuindo um valor a um array
		idades[0] = 38;
		idade1 = idades[0];
		System.out.println(idade1);
		
		// Exceção lançada quando tentamos acessar uma posição que não existe no array 
		// ArrayIndexOutOfBoundsException
		
		// Inicializando um array em um laço for
		for (int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
		}
		
		// Imprimindo o array em um laço for
		for (int i = 0; i < idades.length; i++) {
			System.out.println(idades[i]);
		}
		
		// Inicializando um array de forma literal
		int[] refs = {1,2,3,4,5};

	}

}
