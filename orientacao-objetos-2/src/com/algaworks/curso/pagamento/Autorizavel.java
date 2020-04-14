package com.algaworks.curso.pagamento;

public interface Autorizavel {

	// Para esse documento ser autorizavel preciso que ele me retorne o valor total
	public double getValorTotal();
}
