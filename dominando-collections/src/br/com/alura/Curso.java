package br.com.alura;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<Aluno>();

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

	// Método que devolve o tempo total de todas as aulas do curso
	// usando stream
	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	// Melhorando o modo como o nosso curso é impresso, sobrescrevendo o seu método
	// toString:
	public String toString() {
		return "[Curso: " + this.nome + ", tempo total: " + this.getTempoTotal() + " minutos ]";
	}

	// Método para matricular um aluno no curso. 
	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
	}

	// Programação defensiva:
	// Devolvendo uma cópia do conjunto para que não seja mais possível alterar o valor
	// desse conjunto por fora da própria classe Curso
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

}
