
public class Nutricionista {

	public static void main(String[] args) {
		Paciente celso =  new Paciente();
		celso.peso = 81;
		celso.altura = 1.83;
		
		IMC imc = celso.calculaIndiceDeMassaCorporal();
		
		System.out.println("Abaixo do peso ideal: " + imc.abaixoDoPesoIdeal);
		System.out.println("Peso ideal: " + imc.pesoIdeal);
		System.out.println("Obeso: " + imc.obeso);
		System.out.println("Graud de obesidade: " + imc.grauObesidade);
	}
}
