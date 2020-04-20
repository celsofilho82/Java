package com.algaworks.curso.fjo.metodoEqualsAndHashcode;

import java.util.HashSet;
import java.util.Set;

public class SimuladorBancoDeDados {
	
	public static Set<Aluno> buscarAlunos(){
		
		Set<Aluno> alunos = new HashSet<Aluno>();
		alunos.add(new Aluno("Celso Ribeiro"));
		alunos.add(new Aluno("Aline Sousa"));
		alunos.add(new Aluno("Levy Gabriel"));
		alunos.add(new Aluno("Cecilia Nunes"));
		
		return alunos;
		
	}

}
