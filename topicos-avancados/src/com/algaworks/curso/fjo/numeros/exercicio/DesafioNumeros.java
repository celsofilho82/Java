package com.algaworks.curso.fjo.numeros.exercicio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DesafioNumeros {

	public static void main(String[] args) {
		
		DecimalFormat formatador = new DecimalFormat("RS #,##0.00");
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o valor do produto R$ ");
		
		double valor = entrada.nextDouble();
		
		BigDecimal valorCalculado = new BigDecimal(valor);
		valorCalculado = valorCalculado.add(valorCalculado.multiply(new BigDecimal("0.10")));
		
		System.out.println("O valor acrescido 10% " + formatador.format(valorCalculado.doubleValue()));
	}

}
