package br.com.alura.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraCSV {

	public static void main(String[] args) throws IOException {
		// Usando a classe Scanner para ler de um arquivo CSV
		
		// Carregando o arquivo CSV
		Scanner scanner = new Scanner(new File("contas.csv"));
		
		// Imprimindo uma linha do arquivo
		// String linha = scanner.nextLine();
		// System.out.println(linha);
		
		// Imprimindo todas as linhas de um arquivo
		while(scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			System.out.println(linha);
			
			// Gerando uma nova linha para separar os dados
			Scanner linhaScanner = new Scanner(linha);
			
			// Usando o locale para definir o "." como separador de milhar 
			linhaScanner.useLocale(Locale.US);
			
			// Usando a "," como delimitador 
			linhaScanner.useDelimiter(",");
			
			// Obtendo cada valor e armazenando em uma variável
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int conta = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			// Formatando a string para impressão
			String valorFormatado = String.format("%s - %04d:%06d - %s - R$%7.2f", tipoConta, agencia, conta, titular, saldo);
			
			System.out.println(valorFormatado);
			
			linhaScanner.close();
			
			// Fazendo um split para separar os valores por virgula
			// String[] valores = linha.split(",");
			// System.out.println(Arrays.toString(valores));	
			// System.out.println(linha);
			// linha = scanner.nextLine();
			
		}
		
		scanner.close();

	}

}
