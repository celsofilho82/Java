package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

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
        
        System.out.println("------ Antes Sort ------");
        
        for (Conta conta : lista) {
			System.out.println(conta + ", " + conta.getTitular().getNome() + ", R$ " + conta.getSaldo());
		}
        
        // Fazendo o sort utilizando um comparador
        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);
        
        // Fazendo o sort utilizando a classe Collections e seus métodos estáticos
        Collections.sort(lista); //Usando a ordem natural definida na classe conta: compareTo
        
        System.out.println("------ Depois Sort ------");
        
        for (Conta conta : lista) {
			System.out.println(conta + ", " + conta.getTitular().getNome() + ", R$ " + conta.getSaldo());
		}
        
	}

}

class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		// Implemetando um comparador de string em ordem alfabetica
		
		String titularC1 = c1.getTitular().getNome();
		String titularC2 = c2.getTitular().getNome();
		
		// Compara os nomes dos titulares para realizar a ordenação
		return titularC1.compareTo(titularC2);
	}

}


class NumeroDaContaComparator implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {
		// return 1 -> c1 maior que c2
		// return -1 -> c1 menor que c2
		// return 0 -> c1 igual c2
		
		return Integer.compare(c1.getNumero(), c2.getNumero());
		
		//		if(c1.getNumero() < c2.getNumero()) {
		//            return -1;
		//        }
		//
		//        if(c1.getNumero() > c2.getNumero()) {
		//            return 1;
		//        }
		//		
		//		return 0;
	}
	
}



