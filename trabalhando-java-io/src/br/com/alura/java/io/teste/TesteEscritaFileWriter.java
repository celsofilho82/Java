package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {
		// Usando o FileWriter para abrir o arquivo e fazer o stream de caracteres
		// e bits deixando o código mais simples.
		// FileWriter é um OutputStreamWriter e é um Writer.
		
		// Alternativa aos: FileOutputStream
		//					OutputStreamWriter
		//					BufferedWriter
		
		FileWriter fw = new FileWriter("lorem2.txt");
		
		// Escrevendo a primeira string no buffer de linha
		fw.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
				
		// Gerando uma nova linha e escrevendo mais uma string no buffer de linha
		fw.write(System.lineSeparator());
		fw.write("It has survived not only five centuries, but also the leap into electronicty pesetting");
				
		// Fechando o arquivos
		fw.close();

	}

}
