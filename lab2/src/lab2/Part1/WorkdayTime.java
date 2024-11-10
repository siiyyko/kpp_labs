package lab2.Part1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WorkdayTime {
	private LocalTime startTime;
    private LocalTime endTime;

    public WorkdayTime(String startTime, String endTime) {
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        this.endTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
