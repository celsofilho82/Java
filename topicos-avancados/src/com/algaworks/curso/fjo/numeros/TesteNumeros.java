package com.algaworks.curso.fjo.numeros;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class TesteNumeros {

	public static void main(String[] args) {
		// Formatando a impressão de números no padrão pt-BR (Baseado nas configurações regionais do computador)
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
		double valorProduto = 1300.59;
		// R$ 1.300,59
		
		System.out.println("Sem Formatação: " + valorProduto);
		System.out.println("Formatado: " + formatador.format(valorProduto));
		
		// Obtendo um número em string e convertendo para um objetod do tipo double.
		// Essa conversão pode gerar uma exceção por isso, temos que colocar um try/catch
		String entrada = "R$ 50,34";
		try {
			System.out.println("Número String: " + entrada);
			double numero = formatador.parse(entrada).doubleValue();
			System.out.println("Número convertido: " + numero);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Classe BigDecimal
		// Uma classe que não possui a limitação dos tipos primitivos. 
		// Pode trabalhar com números grandes e possui vários metódos já definidos. 
		BigDecimal bg = new BigDecimal(50000);
	}
}
