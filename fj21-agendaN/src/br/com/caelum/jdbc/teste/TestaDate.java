package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.sql.Date;

public class TestaDate {

	public static void main (String[] args) {
		Calendar c = Calendar.getInstance();
				
		System.out.println(new Date(c.getTimeInMillis()));
		
	}
	
}
