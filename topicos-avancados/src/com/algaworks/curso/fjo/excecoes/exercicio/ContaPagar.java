package com.algaworks.curso.fjo.excecoes.exercicio;

public class ContaPagar extends Conta{
	
	private Fornecedor fornecedor;
	
	public ContaPagar() {
		super();
	}
	public ContaPagar(Fornecedor fornecedor, String descricao, Double valor, String dataVencimento) {
		super();
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}
	
	public void pagar() throws OperacaoContaException {
		if (situacaoConta == SituacaoConta.PENDENTE) {
			situacaoConta = SituacaoConta.PAGA;
			System.out.println("Descrição: " + descricao);
			System.out.println("Valor: " + valor);
			System.out.println("Data de Vencimento: " + dataVencimento);
			System.out.println("Fornecedor: " + fornecedor.getNome());
			System.out.println("Situação Conta: " + getSituacaoConta());
		} else {
			throw new OperacaoContaException("Você não pode pagar uma conta " + getSituacaoConta());
		}
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void exibirDetalhes() {
		System.out.println("\nConta a Pagar");
		System.out.println("===================================");
		System.out.println("Fornecedor: " + this.getFornecedor().getNome());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Data de Vencimento: " + this.getDataVencimento());
		System.out.println("Situação da Conta: " + this.getSituacaoConta());
		System.out.println("===================================");
	}
	
}
