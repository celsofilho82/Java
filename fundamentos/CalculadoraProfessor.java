public class CalculadoraProfessor {
  public static void main(String[] args) {

    // indica se o calculo detalhado deve ser mostrado
    boolean calculoDetalhado = true;

    // constante PI
    float pi = 3.14f;

    // raio
    float raio = 5.3f;

    // area que é o raio ao quadrado multiplicado por pi
    float area = (raio * raio) * pi;

    // calculo da area sem as casas decimais
    int areaSemCasasDecimais = (int) area;

    if (calculoDetalhado) {
      System.out.println("Area = (" + raio + " * " + raio + ") * " + pi);
    }

    // Imprimir o resultado
    System.out.println("Resultado: " + area);
    System.out.println("Resultado sem as casas decimais: " + areaSemCasasDecimais);
  }
}
