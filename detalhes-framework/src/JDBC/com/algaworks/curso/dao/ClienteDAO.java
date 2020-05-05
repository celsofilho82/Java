package JDBC.com.algaworks.curso.dao;

import JDBC.com.algaworks.curso.modelo.Cliente;

public interface ClienteDAO {
	
	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(long codigo);
}
