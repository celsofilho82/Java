package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		
		// Strings são classes que pertencen ao pacote java.lang
		// O pacote java.lang é o único pacote no Java que não precisamos importar
		// Strings são imutáveis
		
		// Inicialzando uma string
		String nome = "Alura";
		System.out.println(nome);
		
		// Substituindo um caractere
		String outra = nome.replace('A', 'a');
		System.out.println(outra);
		
		// Transformando tudo em minusculo
		String lower = nome.toLowerCase();
		System.out.println(lower);
		
		// Obtendo o caracter de uma determinada posição da string
		char c = nome.charAt(0);
		System.out.println(c);
		
		// Obtendo a posição de um determinado caracter
		int pos = nome.indexOf("ur");
		System.out.println(pos);
		
		// Obtendo partes de uma string "substring"
		String subs = nome.substring(1);
		System.out.println(subs);
		
		// Obtendo o tamanho de uma string
		System.out.println(nome.length());
		
		// Verificando se uma string é vazia
		String vazio = "";
		System.out.println(vazio.isEmpty());
		
		// Verificando se uma string contém uma substring
		System.out.println(nome.contains("Alu"));

	}

}
