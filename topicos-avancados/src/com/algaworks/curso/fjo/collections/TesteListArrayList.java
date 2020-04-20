package com.algaworks.curso.fjo.collections;

import java.util.ArrayList;
import java.util.List;

public class TesteListArrayList {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Celso Ribeiro");
		Aluno a2 = new Aluno("Aline Ribeiro");
		Aluno a3 = new Aluno("Aline Sousa");
		Aluno a4 = new Aluno("Cecilia Nunes");
		Aluno a5 = new Aluno("Levy Gabriel");
		
		// Temos a interface (List) e a classe (ArrayList)
		// A diferença do ArrayLista para o Array é que no ArrayList, 
		// não precisamos definir o tamanho no momento que instanciamos.
		// Usamos os generics <> para informar o tipo de objeto que vamos inserir na lista.
		
		List<Aluno> alunos = new ArrayList<Aluno>(); 
		
		// Adicionando elementos em uma ArrayList
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		alunos.add(a4);
		alunos.add(a5);
		
		// Chamando o método imprimir Alunos
		imprimirAlunos(alunos);
	}
	
	public static void imprimirAlunos(List<Aluno> alunos) {
		// Usando For-Each para imprimir os elementos de um array
		
		for(Aluno a: alunos) {
			System.out.println("Nome: " + a.getNome());
		}
	}

}
