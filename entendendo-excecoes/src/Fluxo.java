
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		metodo1();
		System.out.println("Fim do main");
	}

	private static void metodo1() {
		System.out.println("Ini do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}

	private static void metodo2() {
		System.out.println("Ini do metodo2");
		// criando uma exceção e passando uma mensagem para o seu contrutor
		ArithmeticException exception = new ArithmeticException("deu erro!");
		// lançando a exceção criada
		throw exception;
		
	}
}