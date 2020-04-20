package com.algaworks.curso.fjo.collections;

import java.util.HashSet;
import java.util.Set;

public class TesteSetHashSet {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Celso Ribeiro");
		Aluno a2 = new Aluno("Aline Ribeiro");
		Aluno a3 = new Aluno("Aline Sousa");
		Aluno a4 = new Aluno("Cecilia Nunes");
		Aluno a5 = new Aluno("Levy Gabriel");
		
		// Essa estrutura funciona como um conjunto onde as referências aos objetos são inseridas,
		// não permitindo repetição de objetos e a ordem não importa dos objetos em um HashSet 
		
		// Temos a interface (Set) e a classe (HashSet)
		Set<Aluno> alunos = new HashSet<Aluno>();
		
		// Adicionando elementos no HashSet
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		alunos.add(a4);
		alunos.add(a5);

		// Imprimindo alunos no Hash
		imprimirAlunos(alunos);
	}
	
	public static void imprimirAlunos(Set<Aluno> alunos) {
		for (Aluno a : alunos) {
			System.out.println("Nome: " + a.getNome());
		}
	}

}
