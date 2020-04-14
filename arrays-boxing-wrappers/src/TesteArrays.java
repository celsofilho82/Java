
public class TesteArrays {

	public static void main(String[] args) {
		// Para definir uma array em Java, temos que definir o tipo de dados do array e quantas posições ele tem.
		int[] notas = new int[4];
		
		// Acessando o array e inserindo os valores nas posições
		notas[0] = 10;
		notas[1] = 5;
		notas[2] = 8;
		notas[3] = 9;
		
		// Imprimindo os valores de uma array
		System.out.println("Notas do primeiro aluno: " + notas[0]);
		
		// Percorrendo um array com o for
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Posição [" + i + "] = " + notas[i]);
		}
		
		// Definindo uma array de objetos
		
		Carro[] carros = new Carro[4];
		carros[0] = new Carro();
		carros[0].fabricante = "Chevrolet";
		carros[0].modelo = "Onix";
		carros[0].anoDeFabricacao = 2015;
		
		System.out.println("Fabricante: " + carros[0].fabricante);
		System.out.println("Modelo: " + carros[0].modelo);
		System.out.println("Ano: " + carros[0].anoDeFabricacao);
		
		
	}

}
