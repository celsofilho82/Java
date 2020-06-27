package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		// Diferença entre uma consulta sql e uma Java Persistence Query Language ou
		// JPQL

		String sql = "select * from movimentacao where conta_id = 1";

		// Criamos uma classe Conta() que terá seu setId(1L) e a passamos como
		// parâmetro para esta query
		Conta conta = new Conta();
		conta.setId(1L);
		
		// :pConta é o parametro que vai receber a conta
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Utilizando o método createQuery() que irá encapsular a query, recebendo jpql
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta);

		// O retorno é um ResultList que é uma lista de Movimentacao
		List<Movimentacao> resultList = query.getResultList();

		// Faremos um laço foreach para imprimirmos os dados dessa movimentação
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());
		}

	}

}
