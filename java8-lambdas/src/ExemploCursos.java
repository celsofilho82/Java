import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		// Trabalhando com a API de Streams do Java 8

		/*
		 * Ordenando uma lista pelo número de inscritos utilizando Lambda e Method
		 * References
		 */
		System.out.println("#### Utilizando Lambda e Method References ####");
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(curso -> System.out.println(curso.getNome()));

		/*
		 * Imprimindo todos os cursos que possuem mais de 100 alunos. Todas as
		 * Collections possuem um método chamado Stream que lhe retorna uma "sequência"
		 * de objetos
		 */
		System.out.println("#### Utilizando Stream com Filter ####");
		// Filter: Dado um curso quero que retorne somente os cursos que
		// tem alunos >= 100 e imprima o nome do curso
		cursos.stream().filter(curso -> curso.getAlunos() >= 100).forEach(curso -> System.out.println(curso.getNome()));

		System.out.println("#### Utilizando Stream com Map ####");
		// Map: Dado um curso quero que retorne o numero de alunos inscritos nesse curso
		// e imprima o número de alunos desse curso
		cursos.stream().map(curso -> curso.getAlunos()).forEach(total -> System.out.println(total));

		System.out.println("#### Utilizando Stream com MapToInt ####");
		// MapToInt: Devolve um Stream de inteiros e com esse dados podemos realizar
		// algumas operações como somar a quantidade total de alunos nos cursos com mais
		// de 100 alunos
		int sum = cursos.stream().filter(curso -> curso.getAlunos() >= 100).mapToInt(curso -> curso.getAlunos()).sum();
		System.out.println(sum);

	}
}
