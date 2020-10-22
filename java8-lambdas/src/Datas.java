import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {
	/*
	 * Usando a API de Datas do Java 8
	 */
	public static void main(String[] args) {
		/*
		 * LocalDate: Essa Classe possui diversos métodos staticos para trabalhar com
		 * datas
		 */
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		/*
		 * LocalDate.of: Definindo datas e calculando quantos anos\dias faltam para
		 * chegar naquela determinada data com a classe Period
		 */
		LocalDate olimpiadasToquio = LocalDate.of(2021, Month.JULY, 23);
		System.out.println(olimpiadasToquio);

		Period periodo = Period.between(hoje, olimpiadasToquio);
		System.out.println(periodo);

		/*
		 * plusYears(): Adicionando anos as datas para saber quando será a próxima
		 * olimpiada
		 */
		LocalDate proximasOlimpiadas = olimpiadasToquio.plusYears(4);
		System.out.println(proximasOlimpiadas);

		/*
		 * DateTimeFormatter: Formatando datas segundo um critério definido. Primeiro
		 * definimos o formatador e depois aplicamos a formatação na data que estamos
		 * utilizando
		 */
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = proximasOlimpiadas.format(formatador);
		System.out.println(dataFormatada);

		/*
		 * LocalDateTime: Se precisamos hora ao invés de somente datas, devemos utilizar
		 * a classe LocalDateTime
		 */
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));

		/*
		 * YearMonth: Podemos representar de forma especifica um mês de um determinado
		 * ano sem precisar utilizar a classe LocalDate ou LocalDateTime 
		 * LocalTime: Também é possível especificar uma hora especifica com a classe LocalTime
		 */
		YearMonth mes = YearMonth.of(2021, 6);
		System.out.println(mes);
		
		LocalTime intervalo = LocalTime.of(12, 30);
		System.out.println(intervalo);
	}
}
