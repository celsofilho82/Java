package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoPorCategoria {

	public static void main(String[] args) {

		// Criamos uma categoria que terá seu setId(1L) e a passamos como
		// parâmetro para esta query
		Categoria categoria = new Categoria();
		categoria.setId(2L);

		// Fazendo a consulta JPQL com um JOIN
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Utilizando o método createQuery() que irá encapsular a query, recebendo jpql
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		// O retorno é um ResultList que é uma lista de Movimentacao
		List<Movimentacao> resultList = query.getResultList();

		// Faremos um laço foreach para imprimirmos os dados dessa movimentação
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getCategorias());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());
		}

	}

}
