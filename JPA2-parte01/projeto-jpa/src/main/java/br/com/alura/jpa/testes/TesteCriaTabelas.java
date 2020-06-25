package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {

		// Fábrica responsável por criar os objetos EntityManager, pois é um objeto
		// bastante complexo com muitas informações.
		// Objeto Persistence que representará o arquivo de configuração persistence.xml
		// que neste caso tem o nome de contas <persistence-unit name="contas">
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		// Criamos um objeto central chamado EntityManager que nos permitirá fazer todas
		// as operações do banco.
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();

	}

}
