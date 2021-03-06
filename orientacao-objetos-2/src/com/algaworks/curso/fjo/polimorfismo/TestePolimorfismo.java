package com.algaworks.curso.fjo.polimorfismo;

public class TestePolimorfismo {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setSaldo(4000);
		imprimirSaldo(conta);
		System.out.println();
	//---------------------------------------------
		// Polimorfismo
		// Como ContaCorrente herda de Conta, podemos utilizar os métodos que foram defindos
		// para Conta também em objetos do tipo ContaCorrente
		
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setSaldo(3500);
		imprimirSaldo(contaCorrente);
		System.out.println();
		
	//---------------------------------------------
	// O mesmo também para conta poupança que herda de conta
		
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setSaldo(2000);
		imprimirSaldo(contaPoupanca);
		System.out.println();
	
	//---------------------------------------------
	// Também podemos definir o tipo de objeto da classe pai para os objetos da classe filho
		Conta cc = new ContaCorrente();
		cc.setSaldo(4500);
		imprimirSaldo(cc);
		System.out.println();
	
		Conta cp = new ContaPoupanca();
		cp.setSaldo(1000);
		imprimirSaldo(cp);
		System.out.println();
		
	}
	
	// Criando um metódo statico
	
	public static void imprimirSaldo(Conta conta) {
		System.out.println("Saldo da conta: R$ " + conta.getSaldo());
		
	// Usando o operador instanceof(é do tipo) para verificar se um objeto pertence a uma classe
	// neste exemplo faremos casting de objeto
		if(conta instanceof ContaCorrente) {
			// casting de objeto
			ContaCorrente cc = (ContaCorrente) conta;
			System.out.println("O limite da cc é R$ " + cc.getLimite());
		}
		
		if(conta instanceof ContaPoupanca) {
			// casting de objeto
			ContaPoupanca cp = (ContaPoupanca) conta;
			System.out.println("O rendimento da conta poupança é R$ " + cp.getRendimentos());
		}
	}

}