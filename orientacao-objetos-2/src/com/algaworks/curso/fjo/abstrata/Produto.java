package com.algaworks.curso.fjo.abstrata;

// Colocando a palavra reservada abstract para identificar um classe abstrata
// Ao informar que uma classe é abstrata, não é possível criar um objeto em cima desta classe.

	public abstract class Produto {
		
		String descricao;
		
		// Neste exemplo todas as classes que herdarem da classe produto precisam implementar
		// o método imprimirDescricao pois é um método abastrato.
		public abstract void imprimirDescricao();
		
		public String getDescricao() {
			return descricao;
		}
		
}
