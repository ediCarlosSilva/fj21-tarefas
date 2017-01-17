package br.com.caelum.jdbc.teste;

import java.util.Calendar;

public class Data_Calendar {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);
		
		c.set(Calendar.YEAR, 1995);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		System.out.println("Data e hora atual: " + c.getTime());
		System.out.println("Ano: " + c.get(Calendar.YEAR));
		System.out.println("Mês: " + c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
		
		if ( hora > 6 && hora < 12 ) {
			System.out.println("Bom dia");
		} else if ( hora > 12 && hora < 18) {
			System.out.println("Boa Tarde");
		} else {
			System.out.println("Boa Noite");
		}
		
	}
	
}
