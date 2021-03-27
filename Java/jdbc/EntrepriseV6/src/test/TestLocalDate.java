package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {

	public static void main(String[] args) {
		
		
		String dateSaisie="2021-02-28";
		LocalDate maDate = LocalDate.parse(dateSaisie);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(maDate.format(dtf));
		
		
		
		
		
		LocalDateTime ld3 = LocalDateTime.now();
		
		System.out.println(maDate);
		
		//LocalDate ld2 = LocalDate.of(2021, Month.JANUARY, 31);
	
		//LocalDateTime ldBrazil = LocalDateTime.now(ZoneId.of("Brazil/East"));
		
		//System.out.println("");
		
		//System.out.println(ld3);
		//System.out.println(ldBrazil);
		
	}

}
