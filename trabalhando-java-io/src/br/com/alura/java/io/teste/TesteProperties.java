package br.com.alura.java.io.teste;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) throws IOException {
		// Usando Properties para armazenar arquivos de configuração
		// das nossas aplicações
		
		// Representação dos valores através de um objeto da classe Properties
		Properties props = new Properties(); 
		props.setProperty("login", "alura"); //chave, valor
		props.setProperty("senha", "alurapass");
		props.setProperty("endereco", "www.alura.com.br");
		
		// Gravando o arquivo para realmente externalizar as configurações. 
		// Para tal usa-se o método store da classe Properties
		props.store(new FileWriter("conf.properties"), "algum comentário");
		
		// Lendo uma Properties
		
		// Para ler esse arquivo de properties, basta usar o método load:
		Properties props1 = new Properties();        
		props1.load(new FileReader("conf.properties"));
				
		// Podemos usar o método getProperty(key) da classe Properties para recuperar o seu valor.
		String login = props1.getProperty("login");
		String senha = props1.getProperty("senha");
		String endereco = props1.getProperty("endereco");

		System.out.println(login + ", " + senha  + ", " +  endereco);
	}

}
