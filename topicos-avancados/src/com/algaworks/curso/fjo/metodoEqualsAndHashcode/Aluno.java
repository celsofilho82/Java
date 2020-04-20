package com.algaworks.curso.fjo.metodoEqualsAndHashcode;

public class Aluno {

	private String nome;
	private int idade;
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	// O hash code é utilizado de pesquisa em um Hash.
	// Ao sobrescrever o método equals também temos que sobrescrecer o método hascode para que a consulta
	// seja otimizada para o novo valor setado no equals
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	// Sobrescrevendo o método equal para que a comparação entre dois alunos seja feita usando o
	// atributo nome ao invés de a referência do objeto.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
