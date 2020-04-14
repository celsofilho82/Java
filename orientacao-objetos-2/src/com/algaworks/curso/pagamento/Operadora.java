package com.algaworks.curso.pagamento;

public interface Operadora {
	
	// Para essa interface operadora eu preciso de um documento autorizavel
	// Preciso também de um cartão
	public boolean autorizar(Autorizavel autorizavel, Cartao cartao);
}
