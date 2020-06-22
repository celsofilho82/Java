import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Classe com a resposabilidade de estabelecer uma conexão com o banco de dados

	public Connection recuperarConexao() throws SQLException {
		
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "job1034");
		
		
	}
}
