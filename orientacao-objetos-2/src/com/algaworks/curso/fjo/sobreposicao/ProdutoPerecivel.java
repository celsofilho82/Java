package com.algaworks.curso.fjo.sobreposicao;

import java.util.Date;

public class ProdutoPerecivel extends Produto {

	protected Date dataValidade;
	
	// Sobrepondo o metódo identificar definido na classe pai produtod de onde a classe
	// filho produtoperecivel herda 
	public void identificar() {
		super.identificar();
		System.out.println("Minha data de validade é: " + dataValidade + ".");
	}
}
