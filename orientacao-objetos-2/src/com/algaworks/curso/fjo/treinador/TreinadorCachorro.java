package com.algaworks.curso.fjo.treinador;

// Para usar uma classe de um pacote diferente é necessário antes realizar o import desta classe
import com.algaworks.curso.fjo.animal.Cachorro;

public class TreinadorCachorro {

	public static void main(String[] args) {
		
		Cachorro cachorro = new Cachorro();
		cachorro.setNome("Apollo");
		
		DonoCachorro dono = new DonoCachorro();
		dono.ensinarCachorroSentar(cachorro);
	}

}
