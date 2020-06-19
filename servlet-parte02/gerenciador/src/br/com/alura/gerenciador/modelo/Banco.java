package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// A classe Banco é para simular um banco de dados em memória.
public class Banco {

	// Criando um atributo estatico para simular a criação de chave primária
	// sequêncial como em um banco de dados
	private static Integer chaveSequencial = 1;

	// Atributo estático para guardar uma lista de empresas
	// Sendo o atributo lista estático, estará acessível por qualquer classe da
	// nossa aplicação
	private static List<Empresa> lista = new ArrayList<Empresa>();

	// Lista de usuários
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	// Definindo um bloco estático para popular nossa simulação de banco de dados
	// quando a instância é criada

	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa.setNome("Caelum");
		empresa.setId(chaveSequencial++);
		empresa2.setNome("Alura");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("celso");
		u2.setSenha("12345");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
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
			if (empresa.getId() == empresaId) {
				return empresa;
			}
		}

		throw new NoSuchElementException("Empresa não encontrada");
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}

		}
		return null;

	}

}
