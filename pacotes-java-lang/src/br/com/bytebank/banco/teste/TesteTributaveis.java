package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteTributaveis {

	public static void main(String[] args) {
		
		// package + nomeDaClasse => FQN Full Qualified Name
		ContaCorrente cc= new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorDeImposto calc = new CalculadorDeImposto();
		calc.registra(cc);
		calc.registra(seguro);
		
		System.out.println(calc.getTotalImposto());

	}

}
