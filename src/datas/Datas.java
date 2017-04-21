package datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		LocalDate dataProximaCopa = LocalDate.of(2018, Month.JUNE, 14);
		LocalDate dataNoProximoAno = hoje.plusYears(1);
		
		LocalTime intervalo = LocalTime.of(15, 30);
		
		LocalDateTime agora = LocalDateTime.now();
		
		YearMonth anoMes = YearMonth.now();
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		System.out.println("Data atual: " + formatterData.format(hoje));
		System.out.println("Data daqui 1 ano: " + formatterData.format(dataNoProximoAno));
		System.out.println("Data atual completa: " + formatterDataHora.format(agora));
		System.out.println("Horario atual: " + intervalo);
		System.out.println("Ano e mes atual: " + anoMes);
		
		Period period = Period.between(hoje, dataProximaCopa);
		System.out.println(String.format("Restam %d ano(s) para a Copa do Mundo de 2018", period.getYears()));
	}

}
