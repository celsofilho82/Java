
public class TesteClassesWrapper {
	
	public static void main(String[] args) {
		// Lista de tipos primitivos (byte, short, int, long, float, double e char)
		// 
		// Wrapper siguinifica que vamos envelopar tipos primitivos em uma classe
		//
		// Lista de classes Wrapper para cada tipo primitivo.
		// (byte => Byte, short => Short, int => Integer, long => Long, 
		// float => Float, double => Double e char => Character)
		
		// criando uma variável "x" do tipo primitivo integer e atribuindo o valor 5
		
		int x = 5;
		
		// criando uma variável "i" do tipo da classe Wrapper "Integer" e atribuindo o valor 5
		// a grande vantagem é utilizar os metódos disponíveis na classe reaproveitando o código
		
		Integer i = new Integer(5);
		
		// Outro exemplo: pegando um número que veio de um formulário como string e convertendo
		String valor = "15.5";
		Float v = new Float(valor);
		System.out.println(v + 3);
		
		// Usando algums metódos da classe parseXXX, todas as classes possuem esse metódo.
		int idade = Integer.parseInt("37");
		System.out.println("Daqui a 5 anos você terá: " + (idade + 5) + " anos");
	}

}
