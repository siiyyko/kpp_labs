package lab2.Part1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class DailyWorkhoursRule implements IWorktimeRule{
	
	Map<DayOfWeek, WorkdayTime> workhours;
	
	public DailyWorkhoursRule(Map<DayOfWeek, WorkdayTime> workdayHours) {
        this.workhours = workdayHours;
    }

    public WorkdayTime getWorkdayTime(LocalDate date) {
        return workhours.get(date.getDayOfWeek());
    }
}
