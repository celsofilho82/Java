import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// Criando a primeira conexão com o banco de dados utilizando as interfaces do
		// pacote java.sql (Connection e DriverManager) e o driver de conexão com o
		// banco MySQL mysql-connector-java-8.0.20.jar
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "job1034");

		System.out.println("Fechando conexão!!");

		connection.close();
	}
}
