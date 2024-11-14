package lab1;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Printer {
	public static void print(String header, List<Student> students) {
		System.out.println(header);
		for(var student : students) {
			System.out.print(student + String.format("(%3.3f)", student.calculateAverageMark()) + ", \n");
		}
		System.out.print("\n\n");
	}
	
	public static void print(String header, Student studentNullable) {
		System.out.println(header);
		Optional<Student> student = Optional.ofNullable(studentNullable);
		student.ifPresentOrElse(
				st -> System.out.println(st),
				() -> System.out.println("No such student :(("));
		System.out.print("\n");
	}
	
	public static void printGroupedByMark(String header, Map<Integer, List<String>> groupedStudents) {
		System.out.println(header);
		for(var entry : groupedStudents.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for(var student : entry.getValue()) {
				System.out.print(student + ", ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void printGroupedByGroup(String header, Map<String, List<Student>> groupedStudents) {
		System.out.println(header);
		for(var entry : groupedStudents.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for(var student : entry.getValue()) {
				System.out.print(student._name + " " + student._surname + ", ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void printStrings(String header, List<String> strings) {
		System.out.println(header);
		for(var string : strings) {
			System.out.print(string + ", ");
		}
		System.out.print("\n\n");
	}

	
}
