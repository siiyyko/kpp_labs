package lab2.Part1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorktimeCalculator {
	
	public static int calculateWorktime(Timetable tb, String _start, String _end) {
        LocalDate start = LocalDate.parse(_start, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate end = LocalDate.parse(_end, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        
	    int totalHours = 0;
	    LocalDate current = start;
	    
	    while (!current.isAfter(end)) {
	        if (tb.isWorkday(current) && !tb.isHoliday(current)) {
	            WorkdayTime hours = tb.getWorktime(current);
	            totalHours += Duration.between(hours.getStartTime(), hours.getEndTime()).toHours();
	        }
	        current = current.plusDays(1);
	    }

	    return totalHours;
	}
}
