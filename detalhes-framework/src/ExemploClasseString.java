
public class ExemploClasseString {

	public static void main(String[] args) {
		// Strings são objetos imutáveis.
		
		String nome = "Celso";
		System.out.println(nome.toUpperCase()); // Esse método não modifica a string
		System.out.println(nome);
		
		// Para modificar temos que atribuir o resultado a uma outra variável
		nome = nome.toUpperCase();
		System.out.println(nome);
		
		// Comparando Strings
		String s1 = "Celso";
		String s2 = "Celso";
		
		// Neste caso as variáveis apontam para o mesmo lugar por isso que o return é true
		System.out.println("s1 é igual s2? " + (s1 == s2) );
		
		// Neste caso é falso pois, usando o operador new criamos um novo objeto.
		String s3 = new String("Celso");
		System.out.println("s1 é igual s2? " + (s1 == s3) );
		
		// A forma correta de comparar strings é usando o operador equals
		// com o equal comparamos o conteúdo da string.
		System.out.println("s1 é igual s3? " + (s1.equals(s3)));
		System.out.println("s1 é igual s2? " + (s1.equals(s2)));
		
		// Verificando o conteúdo de uma variável string ignorando o case
		String s4 = "CeLsO";
		System.out.println("s1 é igual s4 ignorando case ? " + (s1.equalsIgnoreCase(s4)));
		
		// Uma string é uma cadeia de caracters com cada caracter em uma posição.
		// Podemos imprimir cada caracter passando sua posição usando o charAt()
		String s = "LABVIRTNET";
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(2));
		System.out.println(s.charAt(8));
		
		// Podemos verificar o tamanho de uma string usando o método length()
		String s5 = "LABVIRTNET Serviços";
		System.out.println(s5.length());
		
		// Criando uma string apartir de um array de char
		// Podemos passar esse array diretamente para o contrutor de string
		char[] array = {'C', 'E', 'L', 'S', 'O'};
		String s6 = new String(array);
		System.out.println(s6);
		
		// Podemos usar 2 métodos de substring:
		// substring(int beginIndex)
		// substring(int beginIndex, int endIndex)
		String s7 = "Desenvolvimento Java";
		System.out.println(s7.substring(16));
		System.out.println(s7.substring(0, 14)); // neste método a última posição é excluida.
		
		// Método trim devolve uma nova string retirando os espaços no inicio e no final 
		String s8 = "   Celso   ";
		System.out.println(s8.trim());
		
		// Usando o método split para "quebrar" uma string por um determinado delimitador gerando um array
		String s9 = "Cursos_online_de_desenvolvimento_de_software";
		String[] array2 = s9.split("_");
		for(int i = 0; i < array2.length; i++) {
			System.out.println("[" + i + "] = " + array2[i]);
		}
		
		// Usando o método indexOf para saber qual a posição de um determinado caracter em uma string
		String s10 = "Cecilia";
		System.out.println(s10.indexOf('i'));// esse mostra a primeira ocorrência do caracter
		System.out.println(s10.lastIndexOf('i'));// esse mostra a última ocorrência do caracter
		
		// Usando o métdo replaceAll para substituir uma determinada ocorrência por outra
		String s11 = "Desenvolvimento Java";
		System.out.println(s11.replaceAll("Java", "Ruby"));
	}

}
