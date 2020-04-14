
public class TesteConstrutor {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Celso Ribeiro");
		
		System.out.println("Nome: \"" + p1.nome + "\" tem " + p1.idade + " anos");
		
		p1.idade = 37;
		
		System.out.println("Nome: \"" + p1.nome + "\" tem " + p1.idade + " anos");
		
	}

}
