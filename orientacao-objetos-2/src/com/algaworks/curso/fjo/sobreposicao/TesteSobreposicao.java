package com.algaworks.curso.fjo.sobreposicao;

import java.util.Date;

public class TesteSobreposicao {

	public static void main(String[] args) {
		ProdutoPerecivel carne = new ProdutoPerecivel();
		carne.descricao = "Picanha Argentina";
		carne.dataValidade = new Date();		
		carne.identificar();
	}

}
