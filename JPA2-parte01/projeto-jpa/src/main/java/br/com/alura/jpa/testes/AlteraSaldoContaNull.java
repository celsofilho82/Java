package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaNull {

	public static void main(String[] args) {
		// Como inserimos uma nova coluna no banco de dados (Saldo) essa classe tem como
		// objetivo inserir dados nos registros que nesse campo estão com valor Null.

		// Obtendo o JPA EntityManager fornecido EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Obtendo a conta que queremos alterar passando a sua chave primaria e a classe
		// do objeto no caso conta.class.
		// Esse objeto se encontra em estado Managed então, quando fizermos qualquer
		// alteração dentro dessa entidade e commitarmos a transação, haverá a
		// sincronização automática dos dados.
		Conta conta = em.find(Conta.class, 1L);

		// Iniciando uma transação e adicionando um valor de saldo a conta
		em.getTransaction().begin();
		conta.setSaldo(500.);
		em.getTransaction().commit();

		emf.close();
	}

}
