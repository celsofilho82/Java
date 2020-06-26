package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		// Inserindo um objeto conta com um novo atributo saldo no banco de dados

		// Obtendo o JPA EntityManager fornecido EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Criando um objeto conta
		Conta conta = new Conta();
		conta.setTitular("Aline Ribeiro");
		conta.setNumero(26266);
		conta.setAgencia(3953);
		conta.setSaldo(200.0);

		// Iniciando uma transação.
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();

		// Entendendo a transição de estado de um objeto Managed

		// Alterando o saldo da conta mas ao invés de colocar a alteração dentro da
		// transação como fizemos, fecharemos o EntityManager com em.close() e
		// posteriormente mudaremos o valor do Saldo() para 500.0.

		conta.setSaldo(500.0);

		// Depois que fechamos com em.close(); todas as contas que antes estavam em
		// estado Managed pelo próprio o EntityManager passam a ser Detached quando este
		// é fechado.

		// Nosso objetivo é transformar as entidades para o estado Managed sempre que
		// possível quando trabalhamos com JPA, para justamente podermos usufruir da
		// sincronização automática.
		// Para isso, criaremos mais um EntityManager após seu fechamento para podermos
		// aplicar em2.merge() com a conta, transformando-a em Managed novamente.
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		em2.merge(conta);

		em2.getTransaction().commit();
		
		em2.close();

	}

}
