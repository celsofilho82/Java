
public class DefinirPreco {

	public static void main(String[] args) {

// Implementação passando argumentos por valor
//		double preco = 140;
//		Produto caneca = new Produto();
//		caneca.definirPreco(preco);
		
// Implementação passando argumentos por referência
		Preco preco = new Preco();
		preco.valorCusto = 140;
		
		Produto caneca = new Produto();
		caneca.definirPreco(preco, 20, 15);
		
		System.out.println("Valor custos: " + preco.valorCusto);
		System.out.println("Valor impostos: " + preco.valorImposto);
		System.out.println("Valor lucro: " + preco.valorLucro);
		System.out.println("Valor venda: " + preco.precoVenda);
		
	}
}
