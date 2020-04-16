package com.algaworks.curso.fjo.datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Temos que importar o pacote Date do java.util
import java.util.Date;

public class TesteDatas {

	public static void main(String[] args) {
		// Obtendo a data e hora atual
		Date hoje = new Date();
		System.out.println(hoje);
		
		// Formatando data com o DateFormat 
		DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatadorData.format(hoje));
		
		// Formatando data e hora com o DateFormat 
		DateFormat formatadorHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(formatadorHora.format(hoje));
		
		// Formatando inverso recebendo uma data em string e convertendo para objeto Date
		String dataAniversario = new String("02/10/1982");
		DateFormat formatadorAniversario = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date aniversario = formatadorAniversario.parse(dataAniversario);
			System.out.println(aniversario);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
