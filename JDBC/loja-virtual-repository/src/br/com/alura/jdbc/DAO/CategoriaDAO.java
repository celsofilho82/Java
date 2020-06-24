package br.com.alura.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "SELECT id, nome FROM categoria";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					Categoria categoria = new Categoria(result.getInt(1), result.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {

		Categoria ultima = null;

		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "SELECT C.id, C.nome, P.id, P.nome, P.descricao FROM categoria C "
				+ "INNER JOIN produto P ON C.id = P.categoria_id";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					if (ultima == null || !ultima.getNome().equals(result.getString(2))) {
						Categoria categoria = new Categoria(result.getInt(1), result.getString(2));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(result.getInt(3), result.getString(4), result.getString(5));
					ultima.adicionar(produto);
				}
			}
		}
		return categorias;
	}

}
