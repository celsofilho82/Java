
public class ArCondicionado {
	
	// Usando o modificador de acesso "private" no atributo para que não seja possível
	// utiliza-lo fora da classe.
	private int temperatura;
	
	// Criando um metódo para trocar a temperatura assim, podemos encapsular o atributo da classe 
	// não expondo esse atributo ao mundo externo
	
	void trocarTemperatura (int temperatura) {
		if(temperatura >= 17 && temperatura <= 25) {
			this.temperatura = temperatura;
		}
	}
	
	// Como agora o atributo está protegido, temos que criar um metódo para obter o valor da temperatura
	int obterTemperatura() {
		return temperatura;
	}
}
