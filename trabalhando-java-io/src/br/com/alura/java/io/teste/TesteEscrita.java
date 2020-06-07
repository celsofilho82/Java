package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		// Fluxo de escrita em arquivo
		
		// Abrindo o arquivo usando FileOutputStream e preparando para escrita
		OutputStream fos = new FileOutputStream("lorem2.txt");
		
		// Obtendo os caracteres e transformando em bits para escreve no arquivo 
		Writer osw = new OutputStreamWriter(fos);
		
		// Criando um buffer de caracteres que vai receber as strings em linha para escrita no arquivo
		BufferedWriter bw = new BufferedWriter(osw);
		
		// Escrevendo a primeira string no buffer de linha
		bw.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
		
		// Gerando uma nova linha e escrevendo mais uma string no buffer de linha
		bw.newLine();
		bw.write("It has survived not only five centuries, but also the leap into electronicty pesetting");
		
		// Fechando o arquivos
		bw.close();
		

	}

}
