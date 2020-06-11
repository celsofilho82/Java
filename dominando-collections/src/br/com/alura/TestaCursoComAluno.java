package br.com.alura;

public class TestaCursoComAluno {

	public static void main(String[] args) {

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

		// Imprimindo todos os alunos matriculados no curso
		// Usando o método das coleções forEach passando uma expressão lambda do Java 8:
		System.out.println("Todos os alunos matriculados: ");
		javaColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});
		
		// Verificando se um determinado aluno está matriculado no curso
		System.out.println("O aluno" + a1 + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));

	}

}
