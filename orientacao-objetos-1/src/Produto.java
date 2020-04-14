
public class Produto {

// Implementação passando argumentos por valor
	
//	void definirPreco(double precoCusto) {
//		// Adiciona 20% ao preço de custo
//		precoCusto *= 1.20;
//	}
	
// Implementação passando argumentos por referência
	
	void definirPreco(Preco preco, double percentualImposto, double margemLucro) {
		preco.valorImposto = preco.valorCusto * (percentualImposto / 100);
		preco.valorLucro = preco.valorCusto * (margemLucro / 100);
		preco.precoVenda = preco.valorCusto + preco.valorImposto + preco.valorLucro;
	}
}
