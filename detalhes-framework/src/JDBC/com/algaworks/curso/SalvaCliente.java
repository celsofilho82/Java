package JDBC.com.algaworks.curso;

import JDBC.com.algaworks.curso.dao.ClienteDAO;
import JDBC.com.algaworks.curso.dao.DAOFactory;
import JDBC.com.algaworks.curso.modelo.Cliente;

public class SalvaCliente {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Celso Ribeiro");
		
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
		clienteDAO.salvar(cliente);
		System.out.println("Cliente salvo com sucesso!");

	}

}
