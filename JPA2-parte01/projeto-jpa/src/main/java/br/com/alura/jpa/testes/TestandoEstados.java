package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// Outros estados possíveis de uma entidade com JPA.

		// Criaremos uma nova Conta() que não terá nenhum vínculo com JPA a princípio

		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(321321);
		conta.setAgencia(123123);

		// A JPA tem o estado Transient para designar este tipo de objeto desvinculado.
		// Sua característica é uma conta que existe na memória, possui informações e
		// não tem Id nenhum, mas pode se tornar Managed futuramente.

		// Para fazer a transição de estado, bastará termos um EntityManager para
		// inserirmos persist() passando a conta.

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Transient -> Managed
		em.persist(conta);

		// Caso queiramos remover a conta Managed, poderemos usar o método remove()
		// passando uma conta que será deletada de seu contexto JPA, o que gerará a
		// sincronização e aplicará um delete no banco de dados, transformando-a em um
		// estado Removed.

		// Managed -> Removed
		em.remove(conta);

		em.getTransaction().commit();

	}

}
