package com.algaworks.curso.pagamento.operadoras;

import com.algaworks.curso.pagamento.Autorizavel;
import com.algaworks.curso.pagamento.Cartao;
import com.algaworks.curso.pagamento.Operadora;

public class Redecard implements Operadora {

	@Override
	public boolean autorizar(Autorizavel autorizavel, Cartao cartao) {
		return cartao.getNumeroCartao().startsWith("456") 
				&& autorizavel.getValorTotal() < 200;
	}

}
