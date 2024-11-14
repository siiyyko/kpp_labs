import java.util.List;

import lab2.Part1.*;
import lab2.Part2.*; 

import lab2.Part1.Timetable;

public class Lab2 {

	public static void main(String[] args) {
		Timetable tt_weekly = SampleDataGenerator.generateWeeklyTimetable();
		System.out.println("A person with weekly timetable worked from 23.08.2023 to 26.08.2023 for: " + WorktimeCalculator.calculateWorktime(tt_weekly, "23.08.2023", "26.08.2023") + " hours.");
		
		Timetable tt_shifts = SampleDataGenerator.generateShiftsTimetable();
		System.out.println("A person with shifted timetable 3-3 worked from 16.08.2023 to 22.08.2023 for: " + WorktimeCalculator.calculateWorktime(tt_shifts, "16.08.2023", "22.08.2023") + " hours.");
		
		TextFileReader tfr = new TextFileReader("D:\\oleksii\\uni\\3COURSE\\1TERM\\KPP\\labs\\lab2\\src\\lab2\\Part2\\text.txt");
		List<String> res = RegexSearcher.search(tfr.read(), "[^.!?]*[1-2]+[0-9]+[0-9]+[0-9]\\.([0-9]|0[1-9]|1[0-2])\\.(0[1-9]|[1-2][0-9]|(3[01]))[^.!?]*[.!?]");
		System.out.println(res);
	}

}

/*
Це речення має в собі дату потрібного формату - 2005.12.06.
При цьому це - вже ні.
А тут має, але не того формату - 25.09.2005.
І тут теж - 2005.23.08.
А це знайде 1997.10.14?
А це не знайде 2005.13.06.
І це теж 2005.12.32.
*/