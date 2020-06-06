package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteLambdas {

	public static void main(String[] args) {
		// Ordenando listas

		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		// Criando um lambda para implementar um comparador por número
		// da conta informando diretamente como parâmetro do método sort
		lista.sort((Conta c1, Conta c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

		// Gerando lambda para implementar um comparador por strint
		// e armazenando a mesma em uma referência
		Comparator<Conta> comparador = (Conta c1, Conta c2) -> {
				String titularC1 = c1.getTitular().getNome();
				String titularC2 = c2.getTitular().getNome();
				return titularC1.compareTo(titularC2);
			};
			
		// ForEach clássico:
		for (Conta conta : lista) {
			System.out.println(conta + ", " + conta.getTitular().getNome() + ", R$ " + conta.getSaldo());
		}
		
		// ForEach usando lambda
		lista.forEach((conta) -> System.out.println(conta + ", " + conta.getTitular().getNome() + ", R$ " + conta.getSaldo()));
		
		// Padrão Iterador:
		
		List<String> nomes = new ArrayList<>();
		nomes.add("Super Mario");
		nomes.add("Yoshi"); 
		nomes.add("Donkey Kong"); 

		Iterator<String> it = nomes.iterator();

		while(it.hasNext()) {
		  System.out.println(it.next());
		}
		

	}

}
