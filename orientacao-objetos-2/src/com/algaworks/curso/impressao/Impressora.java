package com.algaworks.curso.impressao;

public interface Impressora {

	// Uma interface é uma classe 100% abastrata, é o nível máximo de abstração
	// Essa classe abstrata irá receber um documento imprimivel não importando que documento
	// Será criada uma nova interface chamada imprimivel para tratar dos detalhes do documento
	public abstract void imprimir(Imprimivel imprimivel);
}
