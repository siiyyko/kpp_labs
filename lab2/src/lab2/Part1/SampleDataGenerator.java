package lab2.Part1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SampleDataGenerator {

	public static Timetable generateWeeklyTimetable() {
		Set<DayOfWeek> workdays = Set.of(
	            DayOfWeek.MONDAY,
	            DayOfWeek.TUESDAY,
	            DayOfWeek.WEDNESDAY,
	            DayOfWeek.THURSDAY,
	            DayOfWeek.FRIDAY
	    );

		IWorkdayRule wdr = new WeeklyWorkdayRule(workdays);
		
	    Map<DayOfWeek, WorkdayTime> worktimes = Map.of(
	            DayOfWeek.MONDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.TUESDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.WEDNESDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.THURSDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.FRIDAY, new WorkdayTime("10:00", "16:00")
	    );

	    IWorktimeRule wtr = new DailyWorkhoursRule(worktimes);
	    
	    List<Holiday> hds = List.of(
	            new Holiday("24.08"),
	            new Holiday("31.12"),
	            new Holiday("01.01"),
	            new Holiday("14.10"),
	            new Holiday("06.09")
	    );

			return new Timetable(wdr, wtr, hds);
	}

	public static Timetable generateShiftsTimetable() {
		
		int workDays = 3;
		int restDays = 3;
		IWorkdayRule wdr = new ShiftWorkdayRule(LocalDate.of(2023, 8, 16), workDays, restDays);
		
		Map<DayOfWeek, WorkdayTime> worktimes = Map.of(
	            DayOfWeek.MONDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.TUESDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.WEDNESDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.THURSDAY, new WorkdayTime("10:00", "18:00"),
	            DayOfWeek.FRIDAY, new WorkdayTime("10:00", "16:00"),
	            DayOfWeek.SATURDAY, new WorkdayTime("11:00", "16:00"),
	            DayOfWeek.SUNDAY, new WorkdayTime("12:00", "16:00")
	    );

	    IWorktimeRule wtr = new DailyWorkhoursRule(worktimes);
	    
	    List<Holiday> hds = List.of(
	            new Holiday("24.08"),
	            new Holiday("31.12"),
	            new Holiday("01.01"),
	            new Holiday("14.10"),
	            new Holiday("06.09")
	    );		
		
		return new Timetable(wdr, wtr, hds);
	}
}
