package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		// Testando o relacionamento entre a conta e movimentação

		// Criando uma conta
		Conta conta = new Conta();
		conta.setAgencia(123123);
		conta.setNumero(456456);
		conta.setSaldo(300.0);
		conta.setTitular("Leonardo");

		// Criando uma movimentação
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);

		// Transformando a conta e a movimentação em um objeto Managed para realizar a
		// persistência no banco. Para isso criamos um EntityManager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Iniciando uma transação, transformando os objetos em Managed e realizando o
		// commit no banco
		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();

		em.close();

	}

}
