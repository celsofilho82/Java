package com.algaworks.curso.fjo.datas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteCalendar {
	
	// Criando um objeto do tipo calendário
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.DAY_OF_MONTH, 31);
		c.set(Calendar.MONTH, 0); // O mês começa apartir do 0 então 0 = janeiro e assim vai.
		c.set(Calendar.YEAR, 2021);
		c.set(Calendar.HOUR_OF_DAY, 10);
		c.set(Calendar.MINUTE, 30);
		c.set(Calendar.SECOND, 00);
		
		// Formatando o objeto calendar.
		// Temos que transformar o objeto calendar para o tipo date assim podemos formata-lo
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(formatador.format(c.getTime())); // getTime transforma o obj do tipo calendar em obj date
		
		// Somando mais um dia ao mês
		c.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(formatador.format(c.getTime()));
		
		// Alterando um campo da data em especifico sem alterar os demais
		c.roll(Calendar.DAY_OF_MONTH, -1);
		System.out.println(formatador.format(c.getTime()));
	}

}
