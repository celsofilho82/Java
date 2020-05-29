
public class FluxoCheckedUnchecked {

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
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			// evitando que a exceção caia na pilha
			try {
				// criando uma exceção ArithmeticException!
				int a = i / 0;
			} catch (ArithmeticException e) {
				// capturando a exceção, mensagem e pilha
				String msg = e.getMessage();
				System.out.println("ArithmeticException" + msg);
				e.printStackTrace();
			}

		}
		System.out.println("Fim do metodo2");
	}
}
