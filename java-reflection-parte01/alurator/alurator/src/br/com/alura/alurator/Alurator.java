package br.com.alura.alurator;

import javax.management.RuntimeErrorException;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao

		// produto/lista
		String[] partesUrl = url.replaceFirst("/", "").split("/");

		String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0)) + partesUrl[0].substring(1) + "Controller";

		try {
			Class<?> classControle = Class.forName(pacoteBase + nomeControle);

			Object instanciaControle = classControle.newInstance();

			System.out.println(instanciaControle);

			return null;

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
