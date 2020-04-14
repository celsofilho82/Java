package com.algaworks.curso.fjo.exercicios;

public class MaquinaCafe {

	int acucarDisponivel;
	
	void fazerCafe(int quantidadeAcucar) {
		if (getAcucarDisponivel() < quantidadeAcucar) {
			System.out.println("Não há açucar suficiente para fazer seu café.");
		} else {
			setAcucarDisponivel(getAcucarDisponivel() - quantidadeAcucar);
			System.out.println("Seu café quentinho com " + quantidadeAcucar + "g de açucar sai em 1 minuto!");
		}
	}
	
	void fazerCafe() {
		fazerCafe(10);
	}

	public int getAcucarDisponivel() {
		return acucarDisponivel;
	}

	public void setAcucarDisponivel(int acucarDisponivel) {
		this.acucarDisponivel = acucarDisponivel;
	}
}
