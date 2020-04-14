
public class folhaPagamento {

	// Assinatura de uma método
	// retorna um double e recebe como parâmetros(int, int, double, double)
	
	double calcularSalario(int horasNormais, int horasExtras, 
			double valorHoraNormal, double valorHoraExtra) {
		double valorHorasNormais = horasNormais * valorHoraNormal;
		double valorHorasExtras = horasExtras * valorHoraExtra;
		
		return valorHorasNormais + valorHorasExtras; 
	}
}
