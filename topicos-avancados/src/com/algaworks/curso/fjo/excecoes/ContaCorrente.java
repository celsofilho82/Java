package com.algaworks.curso.fjo.excecoes;

public class ContaCorrente {

	private double saldo;
	
	public ContaCorrente(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double deposito) {
		// Lançando uma exceção para não aceitar valor menor que 0
		if(deposito <= 0) {
			throw new IllegalArgumentException("O valor não pode ser menor que 0");
		}
		this.saldo += deposito;
	}
	
	// Informando na assinatura do metódo que vamos utilizar uma exceção checada.
	public void sacar(double quantidade) throws SaldoInsuficienteException{
		double saldoTemp = saldo - quantidade;
		if (saldoTemp < 0) {
			throw new SaldoInsuficienteException("Seu saldo é insuficiente");
		}
		this.saldo -= quantidade;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
