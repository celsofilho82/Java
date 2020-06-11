package br.com.alura;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Criando um curso
		Curso javaColecoes = new Curso("Dominando as Coleções do Java", "Paulo Silveira");

		// Adicionando as alunas no curso
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

		// Criando os alunos
		Aluno a1 = new Aluno("Rodrigo Turini", 34762);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);

		// Matriculando os alunos no curso
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		// Buscando o aluno pela matricula
		System.out.println("Quem é o aluno com a matricula 5617?");
		Aluno aluno = javaColecoes.buscaMatriculado(5617);

	}

}
