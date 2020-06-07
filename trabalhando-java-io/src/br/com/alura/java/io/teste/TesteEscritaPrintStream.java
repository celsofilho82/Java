package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStream {

	public static void main(String[] args) throws IOException {
		// Usando a classe PrintStream para escrever caracteres em arquivos
		// Alternativa aos: FileOutputStream
		//					OutputStreamWriter
		//					BufferedWriter
		
		// Testando o tempo de escrita do arquivo
		long ini = System.currentTimeMillis();
		
		PrintStream ps = new PrintStream("lorem2.txt");
		
		// Escrevendo a primeira string no buffer de linha
		ps.println("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
				
		// Gerando uma nova linha e escrevendo mais uma string no buffer de linha
		ps.println("It has survived not only five centuries, but also the leap into electronicty pesetting");
			
		// Fechando o arquivos
		ps.close();
		
		long fim = System.currentTimeMillis();

        System.out.println("Passaram " + (fim - ini) + " milissegundos");


	}

}
