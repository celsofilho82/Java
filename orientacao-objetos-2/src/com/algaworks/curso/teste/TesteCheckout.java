package com.algaworks.curso.teste;

import com.algaworks.curso.caixa.Checkout;
import com.algaworks.curso.caixa.Compra;
import com.algaworks.curso.impressao.Impressora;
import com.algaworks.curso.impressao.impressoras.ImpressoraEpson;
import com.algaworks.curso.impressao.impressoras.ImpressoraHP;
import com.algaworks.curso.pagamento.Cartao;
import com.algaworks.curso.pagamento.Operadora;
import com.algaworks.curso.pagamento.operadoras.Cielo;
import com.algaworks.curso.pagamento.operadoras.Redecard;

public class TesteCheckout {

	public static void main(String[] args) {
		
		Operadora operadora = new Redecard();
		Impressora impressora = new ImpressoraHP();
		
		Cartao cartao = new Cartao();
		cartao.setNomeTitular("Celso R S Filho");
		cartao.setNumeroCartao("456");
		
		Compra compra = new Compra();
		compra.setNomeCliente("Celso Ribeiro dos Santos Filho");
		compra.setProduto("Garrafa de água");
		compra.setValorTotal(500);
		
		Checkout checkout = new Checkout(operadora, impressora);
		checkout.fecharCompra(compra, cartao);
		
	}

}
