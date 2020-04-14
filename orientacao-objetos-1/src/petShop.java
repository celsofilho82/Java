
public class petShop {

	public static void main(String[] args) {
		Cachorro cachorro = new Cachorro();
		
		cachorro.nome = "Apollo";
		cachorro.raca = "Poodle";
		cachorro.sexo = 'M';
		cachorro.idade = 5;
		
		System.out.println("Nome: " + cachorro.nome);
		System.out.println("Raça: " + cachorro.raca);
		System.out.println("Sexo: " + cachorro.sexo);
		System.out.println("Idade: " + cachorro.idade + " anos");
	}
}
