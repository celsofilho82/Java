package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.EnviadorDeEmail;
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

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
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

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();

		assertEquals(0, encerrador.getTotalEncerrados());
		assertFalse(leilao1.isEncerrado());
		assertFalse(leilao2.isEncerrado());

		// Garantindo que o método atualiza() não foi invocado nenhuma vez.
		verify(daoFalso, never()).atualiza(leilao1);
		verify(daoFalso, never()).atualiza(leilao2);
	}

	@Test
	public void naoDeveEncerrarLeiloesCasoNaoHajaNenhum() {

		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(new ArrayList<Leilao>());

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();

		assertEquals(0, encerrador.getTotalEncerrados());
	}

	@Test
	public void deveAtualizarLeiloesEncerrados() {

		/*
		 * Usando o Método verify do Mockito para verificar se o método que atualiza o
		 * objeto no banco de dados está sendo chamado pelo menos 1 vez durante a
		 * execução
		 * 
		 * Para garantir que um método seja invocado apenas uma única vez num mock,
		 * devemos passar um segundo argumento para o método verify, que é o times(1):
		 */

		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();

		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();

		verify(daoFalso, times(1)).atualiza(leilao1);
	}

	@Test
	public void deveEnviarEmailAposPersistirLeilaoEncerrado() {

		/*
		 * Testando se o leilão realmente é enviado por e-mail quando é persistido O
		 * teste verifica se os métodos foram executados nessa ordem específica:
		 * primeiro o DAO, depois o envio do e-mail.
		 * 
		 * Usamos o método inOrder() do Mockito.
		 */

		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();

		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);

		encerrador.encerra();

		InOrder inOrder = Mockito.inOrder(daoFalso, carteiroFalso);
		inOrder.verify(daoFalso, times(1)).atualiza(leilao1);
		inOrder.verify(carteiroFalso, times(1)).envia(leilao1);
	}
}
