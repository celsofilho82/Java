import java.util.Scanner;

public class EstruturaFor{

  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    System.out.print("Informe o último número: ");
    int numeroFinal = entrada.nextInt();

    // Estrutura do FOR
    // (iniciação; condição; incremento)
    for (int i = 1; i <= numeroFinal; i++){
      System.out.println(i);
    }

  }
}
