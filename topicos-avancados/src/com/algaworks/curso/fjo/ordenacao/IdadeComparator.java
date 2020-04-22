package com.algaworks.curso.fjo.ordenacao;

import java.util.Comparator;

public class IdadeComparator implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		if(p1.getIdade() < p2.getIdade()) {
			return -1; // siginifica que p1 tem que vir na frente de p2. retorna -1
		} else if (p1.getIdade() > p2.getIdade()) {
			return 1; // siginifica que p1 tem que vir atrás de p2. retorna 1
		}
		
		return 0;
	}

}
