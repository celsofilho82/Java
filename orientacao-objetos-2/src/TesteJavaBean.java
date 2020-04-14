
public class TesteJavaBean {

	public static void main(String[] args) {
		PessoaBean pessoa = new PessoaBean();
		
		pessoa.setNome("Celso Ribeiro");
		pessoa.setIdade(37);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
	}

}
