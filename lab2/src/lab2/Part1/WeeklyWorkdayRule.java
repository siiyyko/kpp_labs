package lab2.Part1;

import java.time.LocalDate;
import java.util.Set;
import java.time.DayOfWeek;

public class WeeklyWorkdayRule implements IWorkdayRule{
	
	private Set<DayOfWeek> workdays;
	
    public WeeklyWorkdayRule(Set<DayOfWeek> workdays) {
        this.setWorkdays(workdays);
    }

	public Set<DayOfWeek> getWorkdays() {
		return workdays;
	}

	public void setWorkdays(Set<DayOfWeek> workdays) {
		this.workdays = workdays;
	}
	
    public boolean isWorkDay(LocalDate day) {
    	return workdays.contains(day.getDayOfWeek());
    }

}
