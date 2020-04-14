import java.util.Scanner;

public class EstruturaDoWhile{

  public static void main(String[] args){

    Scanner entrada = new Scanner(System.in);

    int valor = 0;
    int soma = 0;

    // Neste tipo de estrutura o código é executado pelo menos 1 vez.
    do {
      System.out.print("Digite 0 para sair ou qualquer valor para somar: ");
      valor = entrada.nextInt();
      soma += valor;
      System.out.println("Soma: " + soma);
    } while (valor != 0);
  }
}
