package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.LeilaoDao;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;

public class EncerradorDeLeilaoTest {
	/*
	 * Com o Mockito Conseguimos simular o comportamento do DAO e testar a classe
	 * que queríamos sem precisarmos montar cenários no banco de dados!
	 * 
	 * Mock objects são uma ótima alternativa para facilitar a escrita de testes de
	 * unidade para classes que dependem de outras classes!
	 * 
	 * Criamos a classe com o metódo "mock" do Mockito e depois ensinamos como deve
	 * ser o retorno usando o "when" e o "thenReturn"
	 * 
	 * Sempre que for trabalhar com mocks, pense em criar interfaces entre suas
	 * classes. Dessa forma, seu teste e código passam a depender apenas de um
	 * contrato, e não de uma classe concreta.
	 */

	@Test
	public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {

		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();

		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();

		assertEquals(2, encerrador.getTotalEncerrados());
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
	}

	@Test
	public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {

		/*
		 * Alterada a implementação para trabalhar com a Interface
		 * "RepositorioDeLeiloes"
		 *
		 * Sempre que for trabalhar com mocks, pense em criar interfaces entre suas
		 * classes. Dessa forma, seu teste e código passam a depender apenas de um
		 * contrato, e não de uma classe concreta.
		 */
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DAY_OF_MONTH, -1);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(ontem).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(ontem).constroi();

		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();

		assertEquals(0, encerrador.getTotalEncerrados());
		assertFalse(leilao1.isEncerrado());
		assertFalse(leilao2.isEncerrado());
	}

	@Test
	public void naoDeveEncerrarLeiloesCasoNaoHajaNenhum() {

		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(new ArrayList<Leilao>());

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();

		assertEquals(0, encerrador.getTotalEncerrados());
	}
}
