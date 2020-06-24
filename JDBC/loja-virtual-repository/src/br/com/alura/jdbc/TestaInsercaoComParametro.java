package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		// Inserindo no banco dados recebidos por parâmetros
		String nome = "Fogão";
		String descricao = "Fogão Consul";

		// Estabelecendo uma conexão com o banco
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperarConexao();

		// Usando o PreparedStatement para preparar uma declaração utilizando dos dados
		// recebidos por parâmetro e também evita sqlinjection
		PreparedStatement statement = conexao.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nome);
		statement.setString(2, descricao);
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}

		conexao.close();

	}

}
