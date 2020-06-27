package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		// Obtendo a conta que será relacionada no banco
		Conta conta = new Conta();
        conta.setId(1L);
        
        // Criando um cliente para associar com a conta
        Cliente cliente = new Cliente();
        cliente.setNome("Celso Ribeiro");
        cliente.setEndereco("Rua do Ouvidor, 50");
        cliente.setProfissao("Desenvolvedor Java");
        cliente.setConta(conta);

		// Transformando a movimentação e as categorias em um objeto Managed para
		// realizar a persistência no banco. Para isso criamos um EntityManager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Iniciando uma transação, transformando os objetos em Managed e realizando o
		// commit no banco
		em.getTransaction().begin();

		// Transient -> Managed
		em.persist(cliente);
		
		em.getTransaction().commit();

		em.close();

	}

}
