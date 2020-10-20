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
		 * metódo sort e podemos passar para ele um comparador não sendo mais necessário
		 * utilizar a classe Comparator. Esse métdo sort foi implementado utilizando o
		 * recurso de default méthods que são métodos implementados em interfaces e que
		 * possuem corpo(implementação) diferente dos métodos padrão de interface que
		 * são abstratos. Essa é a assinatura de um método Default: default void
		 * sort(Comparator<? super E> c){}
		 */
		palavras.sort(comparador);
		System.out.println(palavras);

		// Enhanced FOR ou ForEach classico
		for (String p : palavras) {
			System.out.println();
		}

		/*
		 * A interface List possui um método Default forEach que receber um Consumer.
		 * Criamos a classe ImprimeNaLinha que implementa a iterface Consumer e
		 * implementamos o metódo accept que diz o que vamos fazer com cada string que
		 * for recebida.
		 */
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);

		/*
		 * Neste exemplo ao invés de criar a Classe que implementa a interface Consumer,
		 * já utilizamos a interface diretamente no método instanciando a interface e
		 * implementando o método abstrato dentro do método que estamos trabalhando.
		 * Essa técnica é chamada de Classes Anônimas.
		 * 
		 * Consumer<String> consumidor2 = new Consumer<String>() {
		 *
		 * @Override public void accept(String s) { System.out.println(s);
		 * 
		 * } };
		 */

		/*
		 * Já o Lambda funciona de forma parecida com uma Classe Anônima onde não é
		 * preciso instanciar a Interface no método que estamos trabalhando conforme
		 * exemplo anterior. Substituindo a Classe ImprimeNaLinha por um Lambda
		 */
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		/*
		 * Vamos substituir agora a implementação da Classe ComparadorPorTamanho por um
		 * Lambda. O Lambda veio para trabalhar com as Interfaces Funcionais, que são
		 * Interfaces que só possuem um método abastrato geralmente são Classes do tipo
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
		 * Podemos ainda melhorar essa comparação usando o Integer.compare(). Essa API
		 * já compara dois números inteiros e já retorna o -1, 0 ou 1 conforme é
		 * utilizado no comparator
		 */
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	}

}

class ImprimeNaLinha implements Consumer<String> {
	// Implementando um classe que vai consumir uma string e que iremos utilizar no
	// método default forEach da interface list

	@Override
	public void accept(String string) {
		System.out.println(string);
	}

}

class ComparadorPorTamanho implements Comparator<String> {
	// Implementando uma classe para alterar a forma de comparação na ordenação
	// Vamos ordenar a string pelo tamanho e não em ordem alfabetica
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}