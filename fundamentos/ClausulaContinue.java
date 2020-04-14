import java.util.Scanner;

public class ClausulaContinue{

  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    System.out.print("Digite um número: ");
    int divisor = entrada.nextInt();

    // Quando encontra o primeiro número divisor sai do programa.
    for (int i = 100; i <= 120; i++){
      if (i % divisor == 0) {
        continue;
      }
      System.out.println(i);
    }

    System.out.println("Fim do programa!");
  }
}
