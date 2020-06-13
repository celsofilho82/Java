package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

// A classe Banco é para simular um banco de dados em memória.
public class Banco {

	// Atributo estático para guardar uma lista de empresas
	// Sendo o atributo lista estático, estará acessível por qualquer classe da
	// nossa aplicação
	private static List<Empresa> lista = new ArrayList<Empresa>();

	// Definindo um bloco estático para popular nossa simulação de banco de dados
	// quando a instância é criada

	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa.setNome("Caelum");
		empresa2.setNome("Alura");
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return lista;
	}

}
