package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.000001);
		assertEquals(mediaLancesEsperador, leiloeiro.getMediaLances(), 0.000001);

	}

	/*
	 * Classes de equival�ncia: S�o testes que s�o similares e a regra diz que vemos
	 * escrever somente um teste por classe de equival�ncia. Para esse cen�rio
	 * podemos escrever os seguintes testes: Lances em Ordem Crescente - Lances em
	 * Ordem Decrescente - Lances em Ordem Rand�mica - Leil�o com apenas um Lance
	 * 
	 */
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario joao = new Usuario("Jo�o");
		Leilao leilao = new Leilao("Playstation 4");
		leilao.propoe(new Lance(joao, 1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 450.0));
		leilao.propoe(new Lance(maria, 120.0));
		leilao.propoe(new Lance(joao, 700.0));
		leilao.propoe(new Lance(jose, 630.0));
		leilao.propoe(new Lance(maria, 230.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 330.0));
		leilao.propoe(new Lance(jose, 215.0));
		leilao.propoe(new Lance(maria, 135.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(330.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(135.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 4");
		
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(3, tresMaiores.size());
		assertEquals(400.0, tresMaiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, tresMaiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, tresMaiores.get(2).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 4");
		
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(2, tresMaiores.size());
		assertEquals(200.0, tresMaiores.get(0).getValor(), 0.00001);
		assertEquals(100.0, tresMaiores.get(1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverListaVaziaCasoNaoHajaLances() {
		Leilao leilao = new Leilao("Playstation 4");
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(0, tresMaiores.size());
	}
}
