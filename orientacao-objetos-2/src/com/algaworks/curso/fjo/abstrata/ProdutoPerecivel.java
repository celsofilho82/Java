package com.algaworks.curso.fjo.abstrata;

public class ProdutoPerecivel extends Produto {
	
	String dataValidade;

	public void imprimirDescricao() {
		System.out.println("Descrição: " + descricao + " Vencendo em: " + dataValidade);
	}

}
