public class OperadorIncrementoDecremento{

  public static void main(String[] args){

    int idade = 10;

    // Primeiro atribui o valor a variável novaIdade e depois incrementa
    int novaIdade = idade++;

    // Primeiro incrementa o valor e depois atribui o valor a novaIdade
    novaIdade = ++idade;

    System.out.println("Idade: " + idade);
    System.out.println("Nova Idade: " + novaIdade);
  }
}
