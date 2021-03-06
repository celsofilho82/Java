package com.algaworks.curso.fjo.exercicios;

public class ContaReceber extends Conta{
	
	private Cliente cliente;
	
	public ContaReceber() {
		super();
	}
	
	public ContaReceber(Cliente cliente, String descricao, Double valor, String dataVencimento) {
		super();
		this.cliente = cliente;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void cancelar() {
		if (this.getValor() > 50000d) {
			System.out.println("Essa conta a receber não pode ser cancelada. " +
				"É muito dinheiro para deixar de receber: " + this.getDescricao());
		} else {
			super.cancelar();
		}
	}
	
	public void receber() {
		if (situacaoConta == SituacaoConta.PENDENTE) {
			situacaoConta = SituacaoConta.PAGA;
			System.out.println("Descrição: " + descricao);
			System.out.println("Valor: " + valor);
			System.out.println("Data de Vencimento: " + dataVencimento);
			System.out.println("Cliente: " + cliente.getNome());
			System.out.println("Situação Conta: " + getSituacaoConta());
		} else {
			System.out.println("Você não pode pagar uma conta: " + getSituacaoConta());
		}
	}

	public void exibirDetalhes() {
		System.out.println("\nConta a Receber");
		System.out.println("===================================");
		System.out.println("Cliente: " + this.getCliente().getNome());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Data de Vencimento: " + this.getDataVencimento());
		System.out.println("Situação da Conta: " + this.getSituacaoConta());
		System.out.println("===================================");
	}


}
