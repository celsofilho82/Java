
// Importando a biblioteca para receber o input do teclado do usuário
import java.util.Scanner;

public class EntradaDeDados {

  public static void main(String[] args) {

    // Criando uma instância da classe scanner e armazenando na variável
    Scanner entrada = new Scanner(System.in);

    System.out.println("Informe o seu nome: ");
    String nome = entrada.nextLine();

    System.out.println("Oi " + nome);

  }
}
