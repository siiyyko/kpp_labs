package lab1;

import java.util.ArrayList;

public class StudentCreator {

	public Student create(String studentString) throws Exception {
		String[] fields = studentString.split(" ");
		
		if(fields.length < 3) throw new Exception("Wrong student info exception.");	
		String name, surname, group, workplace = "";
		var marks = new ArrayList<Mark>();
		boolean isExtraMural = false;
		
		name = fields[0];
		surname = fields[1];
		group = fields[2];
		
		int indexForMarks = 3;
		if(surname.contains("_EMS")) {
			surname = surname.replace("_EMS", "");
			isExtraMural = true;
			workplace = fields[3];
			indexForMarks = 4;
		}
		
		for(int i = indexForMarks; i < fields.length; ++i) {
			String[] mark_parted = fields[i].split("_");
			if(mark_parted.length != 2) throw new Exception("Wrong student info exception.");
			
			try {
				marks.add(new Mark(mark_parted[0], Integer.valueOf(mark_parted[1])));
			}
			catch(Exception e) {
				System.out.println("An error occurred while parsing the mark");
				e.printStackTrace();
			}
		}
		
		Student student;
		
		if(isExtraMural) student = new ExtramuralStudent(name, surname, group, workplace, marks);
		else student = new Student(name, surname, group, marks);
		
		return student;
	}
}
