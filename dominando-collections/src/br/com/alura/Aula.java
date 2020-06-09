package br.com.alura;

public class Aula implements Comparable<Aula> {
	// Definindo uma classe aula para trabalhar com as coleções

	private String titulo;
	private int tempo;

	public Aula(String titulo, int tempo) {
		this.titulo = titulo;
		this.tempo = tempo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getTempo() {
		return tempo;
	}

	@Override
	public String toString() {
		// Sobreescrevendo o método da classe mãe
		return "[Aula: " + this.titulo + ", " + this.tempo + " minutos]";
	}

	@Override
	public int compareTo(Aula outraAula) {
		// Definindo um critério de comparação para os objetos desse tipo.
		// Usando o titulo como forma de comparação entre duas aulas
		return this.titulo.compareTo(outraAula.getTitulo());
	}
}
