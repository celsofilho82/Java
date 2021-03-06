package com.algaworks.curso.fjo.exercicios;

public abstract class Conta {

	protected String descricao;
	protected double valor;
	protected String dataVencimento;
	protected SituacaoConta situacaoConta;
	
	public abstract void exibirDetalhes();
	
	public Conta() {
		this.situacaoConta = SituacaoConta.PENDENTE;
	}
	
	public void cancelar() {
		if (situacaoConta == SituacaoConta.PENDENTE) {
			situacaoConta = SituacaoConta.CANCELADA;
			System.out.println("Sua conta foi " + getSituacaoConta());
		} else {
			System.out.println("Não é possivel cancelar uma conta: " + getSituacaoConta());
		}
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}

}
