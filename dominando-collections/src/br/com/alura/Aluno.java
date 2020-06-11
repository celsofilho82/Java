package br.com.alura;

public class Aluno {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		// Se o nome for nulo lança uma NullPointerException.
		if (nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		}

		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	@Override
	public String toString() {
		return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula + "]";
	}

	// Regra Geral:
	// Sempre que reescrever o método equals temos que reescrever também o método
	// hashCode

	@Override
	// Sobrescrevendo o método equals utilizando o nome para comparação.
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		return this.nome.equals(outroAluno.nome);
	}

	@Override
	// Sobrescrevendo o método hashCode utilizando o nome para comparação.
	public int hashCode() {
		return this.nome.hashCode();
	}

}
