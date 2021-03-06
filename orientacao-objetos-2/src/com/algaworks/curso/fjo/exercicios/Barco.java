package com.algaworks.curso.fjo.exercicios;

public class Barco implements Seguravel {

	private int anoFabricacao;
	private double valorMercado;
	
	public Barco(int anoFabricacao, double valorMercado) {
		this.anoFabricacao = anoFabricacao;
		this.valorMercado = valorMercado;
	}
	
	@Override
	public double calcularValorApolice() {
		double valorApolice = this.valorMercado * 0.08;
		if (anoFabricacao < 2000) {
			valorApolice = valorApolice * 0.10;
		}
		return valorApolice;
	}

	@Override
	public String obterDescricao() {
		return "Barco ano " + this.anoFabricacao + " com valor de mercado " 
				+ this.valorMercado;
	}

}
