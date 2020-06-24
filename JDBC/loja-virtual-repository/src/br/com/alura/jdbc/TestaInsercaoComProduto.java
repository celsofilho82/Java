package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				statement.setString(1, comoda.getNome());
				statement.setString(2, comoda.getDescricao());
				
				statement.execute();
				
				try(ResultSet result = statement.getGeneratedKeys()){
					while(result.next()) {
						comoda.setId(result.getInt(1));;
					}
				}

			}
		}
		System.out.println(comoda);
	}

}
