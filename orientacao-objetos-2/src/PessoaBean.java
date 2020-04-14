
public class PessoaBean {

	// Para ser uma classe java bean a maioria dos atributos precisam ser private
	private String nome;
	private int idade;
	
	// Para uma classe bean temos que definir um contrutor padrão para a classe
	
	public PessoaBean(){
		
	}
	
	// Para acessar e modificar os atributos é preciso definir os metódos setters e getters
	// todos os metódos setters e getters são publicos
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
