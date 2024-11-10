package lab2.Part1;

import java.time.LocalDate;
import java.util.List;

public class Timetable {
	private IWorkdayRule workdays;
	private IWorktimeRule worktimes;
	private List<Holiday> holidays;
	
	public Timetable(IWorkdayRule _workdays, IWorktimeRule _worktimes, List<Holiday> _holidays) {
		setWorkdays(_workdays);
		setWorktimes(_worktimes);
		setHolidays(_holidays);
	}

	void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	void setWorktimes(IWorktimeRule worktimes) {
		this.worktimes = worktimes;
	}

	void setWorkdays(IWorkdayRule workdays) {
		this.workdays = workdays;
	}
	
	public boolean isWorkday(LocalDate date) {
		return workdays.isWorkDay(date);
	}
	
	public boolean isHoliday(LocalDate date) {
		return holidays.stream().anyMatch(holiday -> holiday.isHoliday(date));
	}
	
	public WorkdayTime getWorktime(LocalDate date) {
		return worktimes.getWorkdayTime(date);
	}
	
}
