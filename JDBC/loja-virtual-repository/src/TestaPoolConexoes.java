import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		// Testando o pool de conexões realizando a abertura de 20 conexões onde o pool
		// está setado para atander somente 15
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de nº " + i);
		}

	}

}
