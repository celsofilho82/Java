package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		// Fluxo de entrada com arquivo que utiliza o padrão de projeto "Decorator"
		// Stream - input stream of bytes
		// Reader - reading character streams
		
		// Usando a classe FileInputStream passando como parâmetro o nome do arquivo
		// essa classe lança uma exceção checked "FileNotFoundException"
		// InputStream -> classe abstrata que representa um fluxo de bits
		InputStream fis = new FileInputStream("lorem.txt");
		
		// FileInputStream retorna o binário do arquivo. Usamos a classe InputStreamReader passando o FileInput
		// para transformar os binários do FileInputStream em caracteres
		// Reader -> classe abstrata que representa um fluxo de caracters
		Reader isr = new InputStreamReader(fis);
		
		// Armazenamos esses caracteres que representam uma linha do arquivos em um buffer
		// usando a classe BufferedReader. Não podemos representar pela classe abstrata "Reader"
		// pois nessa classe não possui o método readLine.
		BufferedReader br = new BufferedReader(isr);
		
		// Usando o método readLine que retorna a string que representa uma linha
		// esse método lança uma exceção IOException
		String linha = br.readLine();
		
		// Imprimindo a linha
		System.out.println(linha);
		
		// Imprimindo todas as linhas
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		// Fechando o arquivo
		br.close();

	}

}
