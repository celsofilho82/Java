package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {

		// Inserindo um objeto conta no banco de dados

		// Obtendo o objeto principal da JPA EntityManager que é fornecido pelo
		// EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Criando um objeto conta
		Conta conta = new Conta();
		conta.setTitular("Celso Ribeiro");
		conta.setNumero(39006);
		conta.setAgencia(1438);

		// Todo o comando de mudança de estado que executamos na JPA obrigatoriamente
		// tem que está dentro de uma transação.
		
		em.getTransaction().begin(); // Inicio da transação
		
		em.persist(conta);

		em.getTransaction().commit(); // Fim da transação
		
		emf.close();
	}

}
