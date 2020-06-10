package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		// Implementando Set(Conjuntos)
		
		// Criando um conjunto inicializando um HashSet
		Set<String> alunos = new HashSet<String>();

		// Adicionando elementos ao conjunto
		alunos.add("Rodrigo Turin");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		
		// Acessando os elementos do conjunto usando um foreach
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
	}

}
