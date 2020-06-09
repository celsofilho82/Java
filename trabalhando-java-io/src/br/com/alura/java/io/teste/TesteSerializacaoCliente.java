package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// Serializando uma classe para que a classe possa ser serializavel
		// a mesma precisar assinar um contrato implementando a interface Serializable 
		// caso contrário uma exceção é lançada: NotSerializableException
		
		// Criando uma estância da classe cliente
		Cliente cliente = new Cliente();
		cliente.setNome("Celso Ribeiro");
		cliente.setProfissao("Desenvolvedor Java");
		cliente.setCpf("82698767553");
		
		// Serializando o objeto cliente
		ObjectOutputStream clienteBin = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
		clienteBin.writeObject(cliente);
		clienteBin.close();
		
		// Deserializando o objeto cliente
		ObjectInputStream clienteBin2 = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente2 = (Cliente) clienteBin2.readObject();
		clienteBin2.close();
		System.out.println(cliente2.getNome());
		
		
	}

}
