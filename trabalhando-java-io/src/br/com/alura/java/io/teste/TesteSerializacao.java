package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Realizado a serialização de objetos
		// A é a transformação de um objeto em um fluxo binário 
	    // B é a criação de um objeto a partir de um fluxo binário de dados
		
		// Criando um objeto para serialização
		String nome = "Celso Ribeiro";
		
		// Serializando para um arquivo - lança uma exceção FileNotFoundException
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
		oss.writeObject(nome);
		oss.close();
		
		// Deserializando de um arquivo - lança uma exceção ClassNotFoundException
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		String nome1 = (String) ois.readObject();
		System.out.println(nome1);
		
	}

}
