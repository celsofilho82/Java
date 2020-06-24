package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

	public String getNome() {
		return this.nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
