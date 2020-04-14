
public class Carro {

	String fabricante; // atributos do tipo objeto são sempre inicializadas com valor "null"
	String modelo;
	String cor;
	int anoDeFabricacao; // atributos do tipo int, double etc.. são sempre inicializadas com valor "0"
	boolean biCombustivel; // atributos do tipo boolean são sempre inicializadas com valor "false"
	
	Proprietario dono; // atributos do tipo objeto são sempre inicializadas com valor "null"
	
	// definindo o metódo
	// void siginifica que o metódo não vai retornar nada
	void ligar() {
		// implementando clausula Guard
		if (modelo == null) {
			return;
		}
		System.out.println("Ligando o carro: " + modelo);
	}
	
	
}
