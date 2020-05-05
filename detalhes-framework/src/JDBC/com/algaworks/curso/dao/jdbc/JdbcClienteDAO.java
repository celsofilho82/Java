package JDBC.com.algaworks.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.com.algaworks.curso.dao.ClienteDAO;
import JDBC.com.algaworks.curso.dao.DAOException;
import JDBC.com.algaworks.curso.modelo.Cliente;

public class JdbcClienteDAO implements ClienteDAO {

	private Connection connection;
	
	public JdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Cliente cliente) {
		
		try {
			String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Cliente buscarPeloCodigo(long codigo) {
		Cliente cliente = null;
		
		try {
			String sql = String.format("select * from cliente where codigo = %d", codigo);
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cliente;
	}

}
