package com.algaworks.curso.fjo.excecoes;

public class TesteExcecoesChecadas {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(100);
		
		// Criando sua própria exceção para validar regras de negócio
		// Toda vez que utilizamos uma exceção checada é obrigatório o uso do try - catch
		
		try {
			cc.sacar(60);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Desculpe: " + e.getMessage());
		}
		System.out.println("Saldo: " + cc.getSaldo());
		
		try {
			cc.sacar(50);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Desculpe: " + e.getMessage());
		} finally { // Finally sempre será executado
			System.out.println("Obrigado por utilizar nosso sistema!");
		}
		System.out.println("Saldo: " + cc.getSaldo());
	}

}
