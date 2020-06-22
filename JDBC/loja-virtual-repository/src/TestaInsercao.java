import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		// Inserindo dados no banco de dados

		// Estabelecendo uma conexão com o banco
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperarConexao();

		// Criando o Statement para gerar o comando SQL
		Statement statement = conexao.createStatement();

		// Inserindo o comando SQL no statement e obtendo o id que foi gerado para o
		// registro cirado. Neste caso como estamos obtendo o id criado o método execute
		// retorna um objeto ResultSet onde podemos iterar para obter o id criado
		statement.execute("INSERT INTO produto (nome, descricao) VALUES ('Geladeira', 'Geladeira Brastemp')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}

		conexao.close();

	}

}
