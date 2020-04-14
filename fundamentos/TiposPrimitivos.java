public class TiposPrimitivos{
  public static void main(String[] args){
    // Tipo double usado para representar números reais
    double precoProduto = 9.43;

    // Tipo boleano
    boolean alunoMatriculado = true;
    boolean alunoBloqueado = false;

    // Tipo caracter - deve utilizar '' simples
    char turmaAluno1 = 'A';
    char tipoClinete = '2';
    char simbolo = '@';

    // Número inteiro do tipo longo, aceita mais 2 bilhoes
    long populacaoUberlandia = 650000;
    System.out.println(populacaoUberlandia);

    // Para usarmos inteiro do tipo long é necessário colocar a indicação de long(L) no final do número
    long populacaoMundial = 7000000000L;
    System.out.println(populacaoMundial);

    // Mesma coisa para números do tipo float
    float SaldoConta = 1030.43F;
    System.out.println(SaldoConta);
  }
}
