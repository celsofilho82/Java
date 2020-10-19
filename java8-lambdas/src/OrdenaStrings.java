import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		// Ordenando Strings da forma antiga

		List<String> palavras = new ArrayList<String>();
		Comparator<String> comparador = new ComparadorPorTamanho();

		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");

		/*
		 * Collections.sort(palavras, comparador); No java 8 a interface List possui um
		 * met�do sort e podemos passar para ele um comparador n�o sendo mais necess�rio
		 * utilizar a classe Comparator. Esse m�tdo sort foi implementado utilizando o
		 * recurso de default m�thods que s�o m�todos implementados em interfaces e que
		 * possuem corpo(implementa��o) diferente dos m�todos padr�o de interface que
		 * s�o abstratos. Essa � a assinatura de um m�todo Default: default void
		 * sort(Comparator<? super E> c){}
		 */
		palavras.sort(comparador);
		System.out.println(palavras);

		// Enhanced FOR ou ForEach classico
		for (String p : palavras) {
			System.out.println();
		}

		/*
		 * A interface List possui um m�todo Default forEach que receber um Consumer.
		 * Criamos a classe ImprimeNaLinha que implementa a iterface Consumer e
		 * implementamos o met�do accept que diz o que vamos fazer com cada string que
		 * for recebida.
		 */
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
	}

}

class ImprimeNaLinha implements Consumer<String> {
	// Implementando um classe que vai consumir uma string e que iremos utilizar no
	// m�todo default forEach da interface list

	@Override
	public void accept(String string) {
		System.out.println(string);
	}

}

class ComparadorPorTamanho implements Comparator<String> {
	// Implementando uma classe para alterar a forma de compara��o na ordena��o
	// Vamos ordenar a string pelo tamanho e n�o em ordem alfabetica
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}