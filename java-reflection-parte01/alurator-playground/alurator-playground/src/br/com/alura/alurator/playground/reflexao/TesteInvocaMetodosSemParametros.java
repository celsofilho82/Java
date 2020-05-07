package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodosSemParametros {

	public static void main(String[] args) throws Exception{
		
		// O objetivo agora é de posse desses objetos executar/invocar algum método que eles contenham.
		
		
		// Obtendo a classe subControle
		Class<?> subControleClasse = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
		
		// Indica que queremos manipular esse construtor privado
		construtorPadrao.setAccessible(true);
		
		// Instanciação de um objeto da classe SubControle para ser utilizado no método invoke()
		Object subControle = construtorPadrao.newInstance();
		
		// Retorna todos os métodos públicos (e somente eles) referentes à classe.
		// Também aos métodos da superclasse ou das interfaces que a nossa classe implemente. 
		
		// listando todos os métodos publicos da classe SubControle, da sua superclasse (no caso, a classe Controle) 
		// e das interfaces que porventura ela implemente.
		for(Method m : subControleClasse.getMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		// Retorna todos os métodos públicos, privados ou quaisquer forem os modificadores de acesso que eles tenham.
		// No entanto só levará em consideração os métodos da nossa própria classe.
		
		// listando todos os métodos publicos e privados mas somente da classe que estamos inferindo 
		// no caso, SubControle.
		for(Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		// Recuperando somente um método da classe SubControle com o subControleClasse.getMethod()
		// passando o nome do método como que queremos como string 
		Method m = subControleClasse.getDeclaredMethod("metodoSubControle2");
		
		// Indica que queremos manipular esse método privado
		m.setAccessible(true);
		
		// Para executarmos esse objeto, chamaremos o método invoke() que receberá como parâmetro
		// obrigatoriamente, uma instância de SubControle
		
		// Se o método possui retorno, o invoke retorna um Object representando o retorno do método que estamos executando.
		// Caso contrário, o método é executado.
		Object retorno = m.invoke(subControle);
		
		System.out.println(retorno);
	}
}
