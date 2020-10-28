package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
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
	
	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario jose;
	private Usuario joao;
	
	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: Cenário

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// parte 2: Ação
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
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.000001);
		assertEquals(mediaLancesEsperador, leiloeiro.getMediaLances(), 0.000001);

	}

	/*
	 * Classes de equivalência: São testes que são similares e a regra diz que vemos
	 * escrever somente um teste por classe de equivalência. Para esse cenário
	 * podemos escrever os seguintes testes: Lances em Ordem Crescente - Lances em
	 * Ordem Decrescente - Lances em Ordem Randômica - Leilão com apenas um Lance
	 * 
	 */
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new Leilao("Playstation 4");
		leilao.propoe(new Lance(joao, 1000.0));
		
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 450.0));
		leilao.propoe(new Lance(maria, 120.0));
		leilao.propoe(new Lance(joao, 700.0));
		leilao.propoe(new Lance(jose, 630.0));
		leilao.propoe(new Lance(maria, 230.0));
		
		leiloeiro.avalia(leilao);
		
		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(joao, 330.0));
		leilao.propoe(new Lance(jose, 215.0));
		leilao.propoe(new Lance(maria, 135.0));
	
		leiloeiro.avalia(leilao);
		
		assertEquals(330.0, leiloeiro.getMaiorLance(), 0.000001);
		assertEquals(135.0, leiloeiro.getMenorLance(), 0.000001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(3, tresMaiores.size());
		assertEquals(400.0, tresMaiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, tresMaiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, tresMaiores.get(2).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {	
		Leilao leilao = new Leilao("Playstation 4");
		
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
	
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(2, tresMaiores.size());
		assertEquals(200.0, tresMaiores.get(0).getValor(), 0.00001);
		assertEquals(100.0, tresMaiores.get(1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverListaVaziaCasoNaoHajaLances() {
		Leilao leilao = new Leilao("Playstation 4");
		
		leiloeiro.avalia(leilao);
		
		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		assertEquals(0, tresMaiores.size());
	}
}
