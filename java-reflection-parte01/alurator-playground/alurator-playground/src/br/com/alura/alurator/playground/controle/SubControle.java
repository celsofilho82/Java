package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle{

	// Essa é uma classe simples que extende de Controle. Ela tem dois construtores: 
	// um público padrão, e um privado que recebe uma string
	
	public SubControle() {}
	
	private SubControle(String s) {}
	
	public void metodoSubControle1() {
		System.out.println("Executando método SubControle.metodoSubControle1()");
	}
	
	private String metodoSubControle2() {
		System.out.println("Executando método SubControle.metodoSubControle2()");
		
		return "retorno do método SubControle.metodoSubControle2()";
	}
	
}
