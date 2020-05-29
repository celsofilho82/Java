
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		metodo1();
		System.out.println("Fim do main");
	}

	private static void metodo1() {
		System.out.println("Ini do metodo1");
		
		// Outra forma de tratar uma exceção checada é com o
		// bloco try -> catch
		try {
			metodo2();
		} catch (MinhaExcecao e) {
			e.printStackTrace();
		}
		System.out.println("Fim do metodo1");
	}

	private static void metodo2() throws MinhaExcecao {
		System.out.println("Ini do metodo2");
		// Lançando uma exceção checada e deixando explicito na 
		// assinatura do método essa exceção.
		throw new MinhaExcecao("deu muito errado");
		
	}
}