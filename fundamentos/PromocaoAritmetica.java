public class PromocaoAritmetica {
  public static void main(String[] args) {
    // Promoção Aritimetica é promover uma váriavel para um outro tipo e assim realizar operações com essas variáveis
    int x = 3;
    int y = 2;
    // usando casting para promover a variável y assim podemos armazenar o resultado dentro de z que é float
    float z = x / (float) y;
    System.out.println(z);
  }
}
