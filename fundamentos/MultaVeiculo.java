import java.util.Scanner;

public class MultaVeiculo{

  public static void main(String[] args){

    Scanner entrada = new Scanner(System.in);

    System.out.print("Tipo de veiculo (passeio, caminhao): ");
    String tipoVeiculo = entrada.nextLine();

    System.out.print("Velocidade maxima da via: ");
    int velocidadeMaxima = entrada.nextInt();

    System.out.print("Velociade do veiculo: ");
    int velocidadeVeiculo = entrada.nextInt();

    // veiculo de passeio com velocidade maior que 10% da velocidade da via
    // e caminhao com velocidade maior que 5% deve receber multa

    // if (tipoVeiculo.equals("passeio") && velocidadeVeiculo > velocidadeMaxima * 1.1){
    //   System.out.println("Multa!");
    // } else if (tipoVeiculo.equals("caminhao") && velocidadeVeiculo > velocidadeMaxima * 1.05) {
    //   System.out.println("Multa!");
    // }

    // Em apenas uma expressão usando o operador OU ( || )
    if ((tipoVeiculo.equals("passeio") && velocidadeVeiculo > velocidadeMaxima * 1.1) ||
      (tipoVeiculo.equals("caminhao") && velocidadeVeiculo > velocidadeMaxima * 1.05)){
      System.out.println("Multa!");
    }

  }

}
