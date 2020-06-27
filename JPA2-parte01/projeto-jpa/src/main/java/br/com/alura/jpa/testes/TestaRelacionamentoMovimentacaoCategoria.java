package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		// Criando as categorias
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");

		// Criando a conta para associar a movimentação
		Conta conta = new Conta();
		conta.setId(1L);

		// Criando as movimentações e setando as categorias
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem à São Paulo");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		// Método estático da classe Arrays chamado asList(), o qual criará uma lista de
		// forma inline com os argumentos passados.
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem ao Rio de Janeiro");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.0));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);

		// Transformando a movimentação e as categorias em um objeto Managed para
		// realizar a persistência no banco. Para isso criamos um EntityManager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Iniciando uma transação, transformando os objetos em Managed e realizando o
		// commit no banco
		em.getTransaction().begin();

		// Transient -> Managed
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();

		em.close();

	}

}
