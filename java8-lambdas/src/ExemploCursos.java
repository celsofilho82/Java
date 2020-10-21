import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

		System.out.println("#### Utilizando Stream com Any e Optional ####");
		// Any: Podemos aplicar um filtro nas coleções o obter qualquer elemente
		// resultante do filtro ou nenhum e esse valor está dentro do tipo Optional. O
		// orElse(null) diz que se o curso estiver presente retorne o objeto se não
		// retorne null
		Optional<Curso> optionalCurso = cursos.stream().filter(curso -> curso.getAlunos() >= 100).findAny();
		Curso curso = optionalCurso.orElse(null);
		System.out.println(curso.getNome());

		System.out.println("#### Utilizando Stream e gerando nova Collection ####");
		// Collect toList(): Como o Stream retorna objetos do tipo stream e não altera a
		// Collection que ele recebe, se quisermos pegar esse resultado e armazenar em
		// uma outra coleção devemos usar o Collect e seu métodos de classe
		List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());

		System.out.println("#### Utilizando Stream e gerando um MAP ####");
		// Collect toMap(): Esse método vai receber dois Lambdas um para a chave e outro
		// para os valores e vai retornar um Map de cursos
		Map<String, Integer> mapCurso = cursos.stream().filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		System.out.println(mapCurso);
		
		System.out.println("#### Utilizando Stream calcular média alunos ####");
		OptionalDouble averageAlunos = cursos.stream().mapToInt(c -> c.getAlunos()).average();
		averageAlunos.ifPresent(average -> System.out.println(average));
	}
}
