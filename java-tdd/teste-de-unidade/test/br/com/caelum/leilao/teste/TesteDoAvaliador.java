package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	/*
	 * O m�todo Main dessa classe se parece muito com um teste automatizado. Podemo
	 * dividir esse m�todo em algumas partes necess�rias para compor o teste.
	 */

	/*
	 * Para utilizarmos o JUnit devemos alterar o m�todo main para uma assinatura
	 * mais expressiva e anotar o m�todo com @Test
	 */
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: Cen�rio
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// parte 2: A��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// parte 3: Valida��o
		double maiorEsperado = 400.0;
		double menorEsperado = 200.0;
		double mediaLancesEsperador = 300.0;
		/*
		 * Para valida��o utilizaremos a classe Assert que possue uma infinidade de
		 * m�todos utilizado na valida��o dos resultados. assertEquals: Esse
		 * m�todorecebe dois par�metros: o valor esperado e o valor atual
		 */
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.000001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.000001);
		Assert.assertEquals(mediaLancesEsperador, leiloeiro.getMediaLances(), 0.000001);

	}
}
