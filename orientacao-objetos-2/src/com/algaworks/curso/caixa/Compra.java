package com.algaworks.curso.caixa;

import com.algaworks.curso.impressao.Imprimivel;
import com.algaworks.curso.pagamento.Autorizavel;

// Essa classe compra implementa a interface Autorizavel e Imprimivel 
// com métodos presentes nela

public class Compra implements Autorizavel, Imprimivel {

	private double valorTotal;
	private String produto;
	private String nomeCliente;
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCabecalhoPagina() {
		return this.getProduto() + " = " + this.getValorTotal();
	}

	public String getCorpoPagina() {
		return this.getNomeCliente();
	}
	
}
