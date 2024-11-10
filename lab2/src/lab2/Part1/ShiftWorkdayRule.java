package lab2.Part1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShiftWorkdayRule implements IWorkdayRule {
	private LocalDate startDate;
    private int workDays;
    private int restDays;

    public ShiftWorkdayRule(LocalDate startDate, int workDays, int restDays) {
        this.startDate = startDate;
        this.workDays = workDays;
        this.restDays = restDays;
    }

	@Override
	public boolean isWorkDay(LocalDate day) {
			long daysBetween = startDate.until(day, ChronoUnit.DAYS);
			int cycle = workDays + restDays;
			return (daysBetween % cycle) < workDays;
	}
}
