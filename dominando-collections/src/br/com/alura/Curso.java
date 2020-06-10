package br.com.alura;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	// Programação defensiva:
	// Devolvendo uma cópia da lista para que não seja mais possível alterar o valor
	// dessa lista por fora da própria classe Curso
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	// Método adiciona que permite adicionar novas aulas na lista do Curso
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
}
