
public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Simplificando o método abaixo usando o try-with-resources
		
		try(Conexao conexao = new Conexao() ){
			conexao.leDados();
		} catch (Exception e1) {
			System.out.println("Deu erro na conexão");
		}
		
		
//		Conexao con = null;
//		try {
//			Conexao con = new Conexao();
//			con.leDados();
//			con.fecha();
//		} catch (IllegalStateException ex) {
//			System.out.println("Deu erro na conexão");
//		} finally {
//			con.fecha();
//		}
//
	}

}
