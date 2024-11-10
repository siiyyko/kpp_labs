package lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionsHeap {
	
	public static List<Student> getStudentList(String filePath){
		FileReader fr = new FileReader(filePath);
		
		var list = fr.readFile();
		
		var studentCreator = new StudentCreator();
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			for(String row : list) {
				students.add(studentCreator.create(row));
			}
		}
		catch(Exception e) {
			System.err.println("An error occurred while creating a student. Possible data incorrectness");
			e.printStackTrace();
		}
		
		return students;
	}
	
	public static List<Student> where(List<Student> students, Predicate<Student> p) {
		List<Student> aggregatedList = new ArrayList<Student>();
		
		for(Student s : students) {
			if(p.test(s)) {
				aggregatedList.add(s);
			}
		}
		
		return aggregatedList;
	}
	
	public static List<Student> sortByAverageMark(List<Student> students){
		List<Student> sorted = new ArrayList<Student>(students);
		
		int indexMin = 0;
		for(int i = 0; i < sorted.size() - 1; ++i) {
			indexMin = i;
			for(int j = i; j < sorted.size(); ++j) {
				if(students.get(j).calculateAverageMark() < students.get(indexMin).calculateAverageMark())
					indexMin = j;
			}
			Collections.swap(sorted, indexMin, i);
		}
		
		return sorted;
	}
	
	public static Map<String, List<Student>> groupStudentsByGroup (List<Student> students){
		var groupToStudents = new HashMap<String, List<Student>>();
		
		for(Student student : students) {
			if(groupToStudents.containsKey(student._groupName))
				groupToStudents.get(student._groupName).add(student);
			else {
				groupToStudents.put(student._groupName, new ArrayList<Student>());
				groupToStudents.get(student._groupName).add(student);
			}
		}
		
		return groupToStudents;
	}
	
	public static Map<Integer, List<String>> groupStudentsByMarks (List<Student> students, String subjectName){
		var markToStudents = new HashMap<Integer, List<String>>();
		
		for(Student student : students) {
			for(Mark mark : student._marks) {
				if(subjectName.equals(mark.getSubject())) {
					if(markToStudents.containsKey(mark.getRate()))
						markToStudents.get(mark.getRate()).add(student._surname);
					else {
						markToStudents.put(mark.getRate(), new ArrayList<String>());
						markToStudents.get(mark.getRate()).add(student._surname);
					}
				}
			}
		}
		
		return markToStudents;
	}
	
	public static List<String> getUniqueSubjects(List<Student> students){
		List<String> subjects = new ArrayList<String>();
		
		for(var s : students) {
			for(var m : s._marks) {
				if(!subjects.contains(m.getSubject())) subjects.add(m.getSubject());
			}
		}
		
		return subjects;
	}
	
	public static Student getStudentWithBestAverageMark(List<Student> students, String subject) {
		if(students.size() == 0) return null;
		
		Student studentToReturn = null;
		double bestAverage = 0;
		for(var s : students) {
			double average = getAverageMarkOfSubject(s._marks, subject);
			if(average > bestAverage) studentToReturn = s;
		}
		
		return studentToReturn;
		
	}
	
	private static double getAverageMarkOfSubject(List<Mark> marks, String subject) {
		double average = 0;
		int subjectMarksNum = 0;
		for(var m : marks) {
			if(subject.equals(m.getSubject())) {
				average += m.getRate();
				subjectMarksNum++;
			}
		}
		
		if(subjectMarksNum == 0) return 0.0;
		return average / subjectMarksNum;
	}
	
	public static List<String> getUniqueSubjectsStream(List<Student> students) {
		var uniqueSubjectsStream = students.stream()
				.flatMap(student -> student._marks.stream()
						.map(mark -> mark.getSubject()))
				.distinct()
				.collect(Collectors.toList());
		return uniqueSubjectsStream;
	}

	public static Map<String, List<Student>> groupStudentsByGroupStream(List<Student> students) {
		var groupedStudentsByStream = students.stream()
				.map(student -> Map.entry(student._groupName, student))
				.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
		return groupedStudentsByStream;
	}

	public static Map<Integer, List<String>> groupStudentsByMarksStream(List<Student> students, String subject) {
		var marksToStudentsStream = students.stream()
				.flatMap(student -> student._marks.stream()
						.filter(mark -> mark.getSubject().equals(subject))
						.map(mark -> Map.entry(mark.getRate(), student._surname)))
				.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
		return marksToStudentsStream;
	}

	public static List<Student> sortByAverageMarkStream(List<Student> students) {
		var sortedStudentsStream = students.stream()
				.sorted((e1, e2) -> Double.compare(e1.calculateAverageMark(), e2.calculateAverageMark()))
				.collect(Collectors.toList());
		return sortedStudentsStream;
	}
	
	public static Student getStudentWithBestAverageMarkStream(List<Student> students, String subject) {
		var bestStudent = students.stream()
				.filter(student -> student._marks.stream()
						.anyMatch(mark -> mark.getSubject().equals(subject)))
        .max(Comparator.comparingDouble(student -> getAverageMarkOfSubject(student._marks, subject)))
        .orElse(null);
		
		return bestStudent;
	}
	
}
