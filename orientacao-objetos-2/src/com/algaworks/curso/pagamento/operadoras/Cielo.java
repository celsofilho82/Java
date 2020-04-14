package com.algaworks.curso.pagamento.operadoras;

import com.algaworks.curso.pagamento.Autorizavel;
import com.algaworks.curso.pagamento.Cartao;
import com.algaworks.curso.pagamento.Operadora;

public class Cielo implements Operadora {

	@Override
	public boolean autorizar(Autorizavel autorizavel, Cartao cartao) {
		return cartao.getNumeroCartao().startsWith("123") 
				&& autorizavel.getValorTotal() < 100;
	}

}
