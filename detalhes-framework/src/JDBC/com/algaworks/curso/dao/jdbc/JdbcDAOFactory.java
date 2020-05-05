package JDBC.com.algaworks.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import JDBC.com.algaworks.curso.dao.ClienteDAO;
import JDBC.com.algaworks.curso.dao.DAOFactory;

public class JdbcDAOFactory extends DAOFactory {

	private Connection connection;
	
	public JdbcDAOFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cadastro_cliente", "root", "job1034");
			
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando conexão com o banco", e);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDAO(connection);
	}
}
