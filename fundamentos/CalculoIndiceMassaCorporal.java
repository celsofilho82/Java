import java.util.Scanner;

public class CalculoIndiceMassaCorporal{
  public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);

    // nextLine() - usado para string
    System.out.print("Digite seu nome: ");
    String nome = entrada.nextLine();

    // nextInt() - usado para inteiro
    System.out.print("Digite seu peso: ");
    int peso = entrada.nextInt();

    // nextDouble() - usado para double
    System.out.print("Digite sua altura: ");
    double altura = entrada.nextDouble();

    double imc = peso / (altura * altura);

    System.out.println("O IMC de: " + nome + ": " + imc);
  }
}
