import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		// removendo dados do banco

		// Estabelecendo uma conexão com o banco
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperarConexao();

		// Criando o Statement para gerar o comando SQL
		Statement statement = conexao.createStatement();

		// Inserindo o comando SQL no statement e obtendo o retorno que é a quantidade
		// de linhas que foram afetadas pelo comando SQL
		statement.execute("DELETE FROM produto WHERE id = 3");
		int linhasModificadas = statement.getUpdateCount();
		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
		
		conexao.close();

	}

}
