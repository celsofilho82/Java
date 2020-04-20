package com.algaworks.curso.fjo.metodoEqualsAndHashcode;

import java.util.Set;

public class TesteSetHashSet {

	public static void main(String[] args) {
		
		// Obtendo a lista de alunos da classe que simula um banco de dados
		Set<Aluno> alunos = SimuladorBancoDeDados.buscarAlunos();
		
		// Esse código só foi possível pois reescrevemos o método (equals) utilizado pelo (método) contains na classe Aluno
		Aluno alunoSorteado = new Aluno("Celso Ribeiro");
		
		if(alunos.contains(alunoSorteado)) {
			System.out.println("Parabéns " + alunoSorteado.getNome() + " Você ganhou um brinde!" );
		} else {
			System.out.println("Aluno não cadastrado no banco de dados");
		}
		
	}

}
