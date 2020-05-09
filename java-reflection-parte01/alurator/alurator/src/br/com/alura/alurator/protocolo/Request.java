package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParams;

	public Request(String url) {
		
		 /*
	     * Casos possiveis:
	     * /controlador/metodo
	     * /controlador/metodo?param1=valor1*param2=valor2
	     */
		
		// O primeiro passo será quebrar a string recebida em duas partes usando a interrogação(?)
		// precisaremos envolvê-lo com colchetes pois (?) é um caractere especial em expressões regulares
		String[] partesUrl = url.replaceFirst("/", "").split("[?]");
		
		// Agora precisaremos pegar a posição 0 do vetor partesUrl e tratar essa string que tem o nome do controlador e o nome do método
		String[] controleEMetodo = partesUrl[0].split("/");
		nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0)) + partesUrl[0].substring(1) + "Controller";
		nomeMetodo = controleEMetodo[1];
		
		// Nesse ponto precisaremos tratar a segunda posição do vetor partesUrl
		// Nessa classe criaremos um Map privado de String para Object que chamaremos de queryParams (os parâmetros que o usuário passou):
		
		// Se o tamanho de partesUrl for maior que 1 construiremos um novo QueryParamsBuilder() da classe QueryParamsBuilder
		// Se não, simplesmente retornaremos um novo Hashmap de String para Object:
		queryParams = partesUrl.length > 1
		        ? new QueryParamsBuilder().comParametros(partesUrl[1]).build()
		        : new HashMap<String, Object>();

	}

	public String getNomeControle() {
		// TODO Auto-generated method stub
		return nomeControle;
	}
	
	public String getNomeMetodo() {
        return nomeMetodo;
    }

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}
