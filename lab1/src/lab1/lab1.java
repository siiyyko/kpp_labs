package lab1;

import java.util.List;
import java.util.stream.Collectors;

public class lab1 {

	public static void main(String[] args) {
		//getting my students!!!
		List<Student> students = FunctionsHeap.getStudentList("src\\lab1\\test.txt");
		
		//taking extramural and normal students from the list!!
		var extramuralStudents = FunctionsHeap.where(students, s -> (s instanceof ExtramuralStudent));
		Printer.print("Extramural students with places of work: ", extramuralStudents);
		var extramuralStudentsStream = students.stream()
				.filter(s -> s instanceof ExtramuralStudent)
				.collect(Collectors.toList());
		Printer.print("Extramural students using stream", extramuralStudentsStream);
		
		var normalStudents = FunctionsHeap.where(students, s -> !(s instanceof ExtramuralStudent));
		Printer.print("Normal students: ", normalStudents);
		var normalStudentsStream = students.stream()
				.filter(s -> !(s instanceof ExtramuralStudent))
				.collect(Collectors.toList());
		Printer.print("Normal students using stream: ", normalStudentsStream);
		
		//casually sorting students by their average mark
		var sortedStudents = FunctionsHeap.sortByAverageMark(students);
		Printer.print("Students sorted by their average mark: ", sortedStudents);
		var sortedStudentsStream = FunctionsHeap.sortByAverageMarkStream(students);
		Printer.print("Students sorted by their average mark using stream: ", sortedStudentsStream);
		
		//if we have a subject "Math" what are the students' marks?
		var marksToStudents = FunctionsHeap.groupStudentsByMarks(students, "Math");
		Printer.printGroupedByMark("Students grouped by marks: ", marksToStudents);
		var marksToStudentsStream = FunctionsHeap.groupStudentsByMarksStream(students, "Math");
		Printer.printGroupedByMark("Students grouped by marks using stream:", marksToStudentsStream);
		
		//grouping students by their group
		var groupedStudents = FunctionsHeap.groupStudentsByGroup(students);
		Printer.printGroupedByGroup("Students grouped by group: ", groupedStudents);
		var groupedStudentsByStream = FunctionsHeap.groupStudentsByGroupStream(students);
		Printer.printGroupedByGroup("Students grouped by group using stream: ", groupedStudentsByStream);
		
		//getting unique subjects from all the students marks
		var uniqueSubjects = FunctionsHeap.getUniqueSubjects(students);
		Printer.printStrings("Unique subjects: ", uniqueSubjects);
		var uniqueSubjectsStream = FunctionsHeap.getUniqueSubjectsStream(students);
		Printer.printStrings("Unique subjects using stream: ", uniqueSubjectsStream);
		
		//testing optional there, we can get null student
		//if subject does not exist (or they don't have marks on it)
		var bestAverageStudentNullable = FunctionsHeap.getStudentWithBestAverageMark(students, "Math");
		Printer.print("Student with the best average mark for the subject: ", bestAverageStudentNullable);
		var bestAverageStudentNullableStream = FunctionsHeap.getStudentWithBestAverageMarkStream(students, "Math");
		Printer.print("Student with the best average mark for the subject using stream: ", bestAverageStudentNullableStream);

	}

}
