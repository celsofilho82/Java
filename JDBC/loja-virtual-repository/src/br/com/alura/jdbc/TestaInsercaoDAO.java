package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.DAO.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoDAO {

	public static void main(String[] args) throws SQLException {
		Produto guardaRoupas = new Produto("Guarda Roupas", "Guarda Roupas 6 Portas");
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(guardaRoupas);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(produto -> System.out.println(produto));
		}
	}

}
