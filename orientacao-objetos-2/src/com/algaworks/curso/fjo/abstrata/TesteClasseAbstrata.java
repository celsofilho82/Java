package com.algaworks.curso.fjo.abstrata;

public class TesteClasseAbstrata {

	public static void main(String[] args) {
		
		// Usando poliformismo 
		Produto p = new ProdutoPerecivel();
		p.descricao = "Picanha Argentina";
		
		// Fazendo casting de objeto por causa do poliformismo
		ProdutoPerecivel pp = (ProdutoPerecivel) p;
		pp.dataValidade = "12/04/2020";
		
		p.imprimirDescricao();

	}

}
