
public class Passeio {

	public static void main(String[] args) {
		Pessoa celso = new Pessoa();
		celso.nome = "Celso Ribeiro";
		
		Cachorro apollo = new Cachorro();
		apollo.nome = "Apollo";
		apollo.raca = "Poddle";
		apollo.sexo = 'M';
		apollo.idade = 5;
		celso.cachorro = apollo;
		
		Caminhada caminhada = new Caminhada();
		
		caminhada.andar(celso);
	}
}
