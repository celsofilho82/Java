package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;

	// Classe com a resposabilidade de estabelecer uma conexão com o banco de dados

	// Criando um construtor para classe responsável por instanciar um pool de
	// conexões
	public ConnectionFactory() {
		ComboPooledDataSource source = new ComboPooledDataSource();
		source.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		source.setUser("root");
		source.setPassword("job1034");
		
		// Configurando um número definido de conexões
		source.setMinPoolSize(15);

		this.dataSource = source;
	}

	public Connection recuperarConexao() throws SQLException {

		// Alterando a implementação ao invés de usar o DriverManager, utilizamos agora o
		// pool de conexão
		return this.dataSource.getConnection();

		// DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root",
		// "job1034");

	}
}
