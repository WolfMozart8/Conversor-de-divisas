package conversor.divisas;

import java.text.DateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date1 = LocalDate.of(2023, 2, 22);
		LocalDate date2 = LocalDate.now();
		int dtime = LocalDateTime.now().getMinute();
		
		long ldays = ChronoUnit.DAYS.between(date1, date2);
		
		Period period = Period.between(date1, date2);
		int days = period.getDays();
		
		
		System.out.println(dtime);
	}

}
