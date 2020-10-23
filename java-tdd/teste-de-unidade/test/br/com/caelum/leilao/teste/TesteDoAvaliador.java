package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	/*
	 * O método Main dessa classe se parece muito com um teste automatizado. Podemo
	 * dividir esse método em algumas partes necessárias para compor o teste.
	 */

	/*
	 * Para utilizarmos o JUnit devemos alterar o método main para uma assinatura
	 * mais expressiva e anotar o método com @Test
	 */
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: Cenário
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// parte 2: Ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// parte 3: Validação
		double maiorEsperado = 400.0;
		double menorEsperado = 200.0;
		double mediaLancesEsperador = 300.0;
		/*
		 * Para validação utilizaremos a classe Assert que possue uma infinidade de
		 * métodos utilizado na validação dos resultados. assertEquals: Esse
		 * métodorecebe dois parâmetros: o valor esperado e o valor atual
		 */
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.000001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.000001);
		Assert.assertEquals(mediaLancesEsperador, leiloeiro.getMediaLances(), 0.000001);

	}
}
