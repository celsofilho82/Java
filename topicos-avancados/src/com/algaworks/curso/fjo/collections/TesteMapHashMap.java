package com.algaworks.curso.fjo.collections;

import java.util.HashMap;
import java.util.Map;

public class TesteMapHashMap {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Celso Ribeiro");
		Aluno a2 = new Aluno("Aline Ribeiro");
		Aluno a3 = new Aluno("Aline Sousa");
		Aluno a4 = new Aluno("Cecilia Nunes");
		Aluno a5 = new Aluno("Levy Gabriel");
		
		
		// A interface (Map) e a classe (HashMap)
		// Estrutura de dados chave:valor onde a chave é o identificador e o valor é objeto.
		Map<String, Aluno> alunos = new HashMap<String, Aluno>();
		
		alunos.put("1", a1);
		alunos.put("2", a2);
		alunos.put("3", a3);
		alunos.put("4", a4);
		alunos.put("5", a5);
		
		imprimirAlunos(alunos);
	}

	private static void imprimirAlunos(Map<String, Aluno> alunos) {
		for (Aluno a : alunos.values()) {
			System.out.println("Nome: " + a.getNome());
		}
	}

}
