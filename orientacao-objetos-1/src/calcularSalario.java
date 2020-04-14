
public class calcularSalario {

	public static void main(String[] args) {
		folhaPagamento folha = new folhaPagamento();
		double salario = folha.calcularSalario(160, 12, 32.50, 40.20);
		
		System.out.println("Salário este mês: " + salario);
	}
}
