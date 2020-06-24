package br.com.alura.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	// Essa classe será responsável por fazer a persitência do produto na base de
	// dados chamado de Data Access Object (DAO)

	// Está ligada com a capacidade de isolar, em um único lugar, todo o código que
	// acessa o seu repositório de dados
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					produto.setId(result.getInt(1));
				}
			}

		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT id, nome, descricao FROM produto";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {

		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT id, nome, descricao FROM produto WHERE categoria_id = ? ";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, categoria.getId());
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;

	}

}
