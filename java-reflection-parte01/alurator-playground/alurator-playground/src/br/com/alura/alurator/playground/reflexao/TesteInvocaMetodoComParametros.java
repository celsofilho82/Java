package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametros {

	public static void main(String[] args) throws Exception {
		
		// Criando um objeto da classe Class<?> inferindo a nossa classe Controle			
		Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		// Obtendo e invocando o construtor padrão dessa classe e criando uma instância da classe Controle.
		Constructor<?> construtorPadrao = controleClasse.getDeclaredConstructor();
        Object controle = construtorPadrao.newInstance();
		
        // Executando o metodo metodoControle2() passando o argumento que ele exige 
        Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class);
        
        // Para invocar o metodo temos que passar a instancia da classe mas o parâmetro
        Object retorno = m.invoke(controle, "Pintassilgo do Agreste");

        System.out.println(retorno);
        
     // Executando um outro metodo metodoControle2() que recebe 2 parametros
        Method m2 = controleClasse.getDeclaredMethod("metodoControle2", String.class, Integer.class);
        Object retorno2 = m2.invoke(controle, "Pintassilgo do Agreste", 2);
        System.out.println(retorno2);
	}

}
