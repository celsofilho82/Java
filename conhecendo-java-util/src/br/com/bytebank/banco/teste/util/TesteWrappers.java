package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrappers {

	public static void main(String[] args) {
	
		// Tabela com os tipos primitivos e respectivos Wrappers
		
		// Tamanho	Tipo primitivo	Wrappers
		// 8 bytes		double		java.lang.Double
		// 4 bytes		float		java.lang.Float
		// 8 bytes		long		java.lang.Long
		// 4 bytes		int			java.lang.Integer
		// 2 bytes		short		java.lang.Short
		// 1 bytes		byte		java.lang.Byte
		// 2 bytes		char		java.lang.Character
		//			boolean		java.lang.Boolean
		
		Integer idadeRef = Integer.valueOf(29); //autoboxing
        System.out.println(idadeRef.intValue()); //unboxing
        
        Double dRef = Double.valueOf(3.2);//autoboxing
        System.out.println(dRef.doubleValue());//unboxing
        
        Boolean bRef = Boolean.FALSE; // True e False são constantes na classe Boolean
        System.out.println(bRef.booleanValue());
        
        // Temos a classe Number(java.lang.Number) que é de onde as classes númericas herdan seus métodos:
        // (Double, Float) ambas flutuantes e (Long, Integer, Short e Byte) representando os inteiros.
        
        Number refNumero = Integer.valueOf(29); // Temos uma referência genérica(Number), capaz de referenciar tipos mais específicos.
        
        // Esta classe(Number) pode ser útil se quisermos criar uma lista que aceite qualquer tipo de valor.
        
        List<Number> lista = new ArrayList<>();
        lista.add(10);   // integer
        lista.add(32.6); // double
        lista.add(25.6f);// float
	}

}
