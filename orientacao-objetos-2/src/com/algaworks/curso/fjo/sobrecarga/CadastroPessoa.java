package com.algaworks.curso.fjo.sobrecarga;

public class CadastroPessoa {

	// Criando um método público para expor o método privado armazenar
	public void cadastrar(Pessoa pessoa) {
		armazenar(pessoa.getNome(), pessoa.getIdade());
	}
	
	// Criando uma 2ª versão do método cadastrar agora recebendo 2 parametros ao invés do objeto
	public void cadastrar(String nome, int idade) {
		armazenar(nome, idade);
	}
	
	private void armazenar(String nome, int idade) {
		// Salva no banco de dados
		System.out.println("Salvando: \"" + nome + "\" com " + idade + " anos");
	}
}
