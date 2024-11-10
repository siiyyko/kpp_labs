package lab2.Part1;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class Holiday {
	private MonthDay date;
	
	public Holiday(String date) {
		
		this.date = MonthDay.parse(date, DateTimeFormatter.ofPattern("dd.MM"));
    }
	
	public boolean isHoliday(LocalDate date) {
		return MonthDay.from(date).equals(this.date);
	}
}
