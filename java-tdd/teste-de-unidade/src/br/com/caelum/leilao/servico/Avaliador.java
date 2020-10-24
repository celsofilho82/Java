package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private OptionalDouble mediaLances;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
			if (lance.getValor() < getMenorLance()) {
				menorDeTodos = lance.getValor();
			}
		}
		
		maiores = new ArrayList<Lance>(leilao.getLances());
		maiores.sort(Comparator.comparing(Lance::getValor).reversed());
		mediaLances = leilao.getLances().stream().mapToDouble(lance -> lance.getValor()).average();
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public Double getMediaLances() {
		return mediaLances.getAsDouble();
	}

	public List<Lance> getTresMaiores() {
		return maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}
}
