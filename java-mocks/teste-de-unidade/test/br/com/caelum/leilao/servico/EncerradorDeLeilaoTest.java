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
	 * que quer�amos sem precisarmos montar cen�rios no banco de dados!
	 * 
	 * Mock objects s�o uma �tima alternativa para facilitar a escrita de testes de
	 * unidade para classes que dependem de outras classes!
	 * 
	 * Criamos a classe com o met�do "mock" do Mockito e depois ensinamos como deve
	 * ser o retorno usando o "when" e o "thenReturn"
	 * 
	 * Sempre que for trabalhar com mocks, pense em criar interfaces entre suas
	 * classes. Dessa forma, seu teste e c�digo passam a depender apenas de um
	 * contrato, e n�o de uma classe concreta.
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
		 * Alterada a implementa��o para trabalhar com a Interface
		 * "RepositorioDeLeiloes"
		 *
		 * Sempre que for trabalhar com mocks, pense em criar interfaces entre suas
		 * classes. Dessa forma, seu teste e c�digo passam a depender apenas de um
		 * contrato, e n�o de uma classe concreta.
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

		// Garantindo que o m�todo atualiza() n�o foi invocado nenhuma vez.
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
		 * Usando o M�todo verify do Mockito para verificar se o m�todo que atualiza o
		 * objeto no banco de dados est� sendo chamado pelo menos 1 vez durante a
		 * execu��o
		 * 
		 * Para garantir que um m�todo seja invocado apenas uma �nica vez num mock,
		 * devemos passar um segundo argumento para o m�todo verify, que � o times(1):
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
		 * Testando se o leil�o realmente � enviado por e-mail quando � persistido O
		 * teste verifica se os m�todos foram executados nessa ordem espec�fica:
		 * primeiro o DAO, depois o envio do e-mail.
		 * 
		 * Usamos o m�todo inOrder() do Mockito.
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
