package edu.val.cle.atsistemas.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class MainFechas {
	
	public static void main(String[] args) {
		LocalTime lt = LocalTime.now(); //hora
		LocalDate ld = LocalDate.now(); //fecha
		LocalDateTime ldt = LocalDateTime.now(); //fecha_hora
		
		ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Madrid"));
		DateTimeFormatter dateTimeFormatterZonaS = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter dateTimeFormatterZonaL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		
		DateTimeFormatter dtft = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter dtfd = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter dtfdt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		System.out.println("HORA_ACTUAL " +lt.format(dtft));
		System.out.println("FECHA_ACTUAL " +ld.format(dtfd));
		System.out.println("FECHA_HORA_ACTUAL" + ldt.format(dtfdt));
		
		//l11n - LOCALIZACIÓN - IDIOMA/REGIÓN
		//Locale locale = new Locale("es");
		Locale aLocale = new Locale.Builder().setLanguage("es").build();

		System.out.println(dateTimeFormatterZonaS.withLocale(aLocale).format(ldt));
		System.out.println(dateTimeFormatterZonaL.withLocale(aLocale).format(zdt));
		

		
		
	}

}
