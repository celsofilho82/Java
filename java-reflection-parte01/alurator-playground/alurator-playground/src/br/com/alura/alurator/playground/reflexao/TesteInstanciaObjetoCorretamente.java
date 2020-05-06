package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;


public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		// O objetivo na classe TesteInstanciaObjetoCorretamente é obtermos tanto os contrutores da classe SubControle quanto os da classe Controle.
		
		// Instanciando os objetos da classe usando o Class<>
		
		Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2 =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 = 
                Class.forName("br.com.alura.alurator.playground.controle.Controle");
        
        // A partir do objeto subControleClasse1, queremos obter o construtor utilizando o método getConstructor() sem passar nenhum parâmetro 
        // ou seja, queremos o construtor da classe SubControle que não recebe nenhum parâmetro.
        
        // Estamos recebendo como retorno um Constructor parametrizado para SubControle. 
        // Criaremos uma instância de Constructor<SubControle> que chamaremos de construtorSubControle
        
        // Temos uma instância de Constructor parametrizado para SubControle que representa um construtor da classe SubControle que não recebe nenhum parâmetro.
        
        Constructor<SubControle> construtorSubControle = subControleClasse1.getConstructor(); 
        
        System.out.println(construtorSubControle); // public br.com.alura.alurator.playground.controle.SubControle()
        
        // Obtendo o construtor privado de SubControle que recebe uma string.
        // O método 'getConstructor() só retorna os métodos públicos da nossa classe
        // Para pegarmos os métodos privados, precisaremos utilizar o método getDeclaredConstructor()
        
        Constructor<SubControle> construtorSubControle2 = subControleClasse1.getDeclaredConstructor(String.class); 

        System.out.println(construtorSubControle2); // private br.com.alura.alurator.playground.controle.SubControle(java.lang.String)
        
        // Utilizando o método newInstance() da classe Constructor para construir um objeto da classe SubControle a partir desse construtor que acabamos de obter.
        // construtorSubControle2 representa o construtor privado da nossa classe por padrão, não conseguimos manipular construtores privados.
        // Para isso, precisaremos utilizar o método setAccessible(), passando o valor true, o que indicará para o Java que podemos manipular construtores privados:
        
        construtorSubControle2.setAccessible(true);
        
        Object subControle = construtorSubControle2.newInstance("Celso");
        System.out.println(subControle); // br.com.alura.alurator.playground.controle.SubControle@270421f5
	}

}
