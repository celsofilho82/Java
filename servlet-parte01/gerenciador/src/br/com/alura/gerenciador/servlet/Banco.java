package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// A classe Banco é para simular um banco de dados em memória.
public class Banco {

	// Atributo estático para guardar uma lista de empresas
	// Sendo o atributo lista estático, estará acessível por qualquer classe da
	// nossa aplicação
	private static List<Empresa> lista = new ArrayList<Empresa>();

	// Definindo um bloco estático para popular nossa simulação de banco de dados
	// quando a instância é criada

	// Criando um atributo estatico para simular a criação de chave primária
	// sequêncial como em um banco de dados
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa.setNome("Caelum");
		empresa.setId(chaveSequencial++);
		empresa2.setNome("Alura");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return lista;
	}

	public void removeEmpresa(Integer empresaId) {

		// Não podemos realizar um forEach alterando a própria lista no laço pois
		// fazendo isso recebemos uma exceção ConcurrentModificationException. O correto
		// é utilizarmos a classe Iterator para realizar essa iteração alterando a lista

		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == empresaId) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresa(Integer empresaId) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == empresaId) {
				return empresa;
			}
		}
		
		throw new NoSuchElementException("Empresa não encontrada");
	}

}
