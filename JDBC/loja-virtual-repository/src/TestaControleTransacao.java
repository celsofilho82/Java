import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaControleTransacao {

	public static void main(String[] args) throws SQLException {

		// Trabalhando com o controle de transações manualmente
		
		// Estabelecendo uma conexão com o banco e retirando o autocommit
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperarConexao();
		
		conexao.setAutoCommit(false);
		
		try {
			PreparedStatement statement = conexao.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			adicionaProdutos("Televisor", "SmartTV AOC", statement);
			adicionaProdutos("Som", "Rádio Philips", statement);
			conexao.commit();
			
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			conexao.rollback();
		}
		conexao.close();
	}

	private static void adicionaProdutos(String nome, String descricao, PreparedStatement statement) throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
	}

}
