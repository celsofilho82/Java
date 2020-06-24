package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		// Instanciando a classe CriaConexao responsável por fazer a conexão com o banco
		// de dados
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperarConexao();

		// Criando um Statement para inserir dados no banco
		Statement statement = connection.createStatement();

		// Executando uma consulta no banco de dados neste caso temos como retorno um
		// valor boleano
		// O método devolve true quando o seu resultado é um java.sql.ResultSet e false
		// caso contrário (update, delete, insert, etc)
		boolean resultado = statement.execute("SELECT * FROM produto");
		System.out.println(resultado);

		// Obtendo o dados da consulta SQL usando um iterador
		ResultSet set = statement.getResultSet();
		while (set.next()) {
			Integer id = set.getInt("ID");
			String nome = set.getString("NOME");
			String descricao = set.getString("DESCRICAO");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}

		connection.close();

	}

}
