package com.algaworks.curso.fjo.classemath;

public class TesteClasseMath {

	public static void main(String[] args) {
		// Comprimento de uma circunferência
		int raio = 4;
		double comprimento = (2 * raio) * Math.PI;
		System.out.println("Comprimento: " + comprimento);

		// Máximo e minimo
		double[] precoProdutoA = {30.20, 24.49};
		double maiorPreco = Math.max(precoProdutoA[0], precoProdutoA[1]);
		double menorPreco = Math.min(precoProdutoA[0], precoProdutoA[1]);
		System.out.println("Maior preço " + maiorPreco);
		System.out.println("Menor preço " + menorPreco);
		
		// Potência
		System.out.println("2^3: " + Math.pow(2, 3));
		
		// Raiz quadrada
		System.out.println("Raiz de 11: " + Math.sqrt(11));
		
		// Arredondamento ceil(arredonda pra baixo), floor(arredonda pra cima) e round
		double n = 5.68;
		System.out.println("Menor inteiro: " + Math.floor(n));
		System.out.println("Maior inteiro: " + Math.ceil(n));
		System.out.println("Arredondando: " + Math.round(n));
		
		// Números randomicos(Aleatórios) entre 0 e 1
		double numeroAleatorio = Math.random();
		System.out.println(numeroAleatorio);
	}

}
