package com.algaworks.curso.fjo.enums;

public enum OperacaoAritmetica {

	ADICAO {
		public int operacao(int x, int y) {
			return x + y;
		}
	},
	SUBTRACAO {
		public int operacao(int x, int y) {
			return x - y;
		}
	};
	
	// Para cada enum ter um metódo distinto usamos a palavra abstract
	public abstract int operacao(int x, int y);
	
}
