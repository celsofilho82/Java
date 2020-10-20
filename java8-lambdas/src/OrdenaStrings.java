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

		/*
		 * Neste exemplo ao inv�s de criar a Classe que implementa a interface Consumer,
		 * j� utilizamos a interface diretamente no m�todo instanciando a interface e
		 * implementando o m�todo abstrato dentro do m�todo que estamos trabalhando.
		 * Essa t�cnica � chamada de Classes An�nimas.
		 * 
		 * Consumer<String> consumidor2 = new Consumer<String>() {
		 *
		 * @Override public void accept(String s) { System.out.println(s);
		 * 
		 * } };
		 */

		/*
		 * J� o Lambda funciona de forma parecida com uma Classe An�nima onde n�o �
		 * preciso instanciar a Interface no m�todo que estamos trabalhando conforme
		 * exemplo anterior. Substituindo a Classe ImprimeNaLinha por um Lambda
		 */
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		/*
		 * Vamos substituir agora a implementa��o da Classe ComparadorPorTamanho por um
		 * Lambda. O Lambda veio para trabalhar com as Interfaces Funcionais, que s�o
		 * Interfaces que s� possuem um m�todo abastrato geralmente s�o Classes do tipo
		 * Comparator ou Consumer
		 */
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;

		});

		/*
		 * Podemos ainda melhorar essa compara��o usando o Integer.compare(). Essa API
		 * j� compara dois n�meros inteiros e j� retorna o -1, 0 ou 1 conforme �
		 * utilizado no comparator
		 */
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
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