package lab2.Part1;

import java.time.LocalDate;

public interface IWorktimeRule {
	public WorkdayTime getWorkdayTime(LocalDate day);
}
