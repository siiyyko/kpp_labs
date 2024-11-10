package lab1;

import java.util.List;

public class Student {
	protected String _surname;
	protected String _groupName;
	protected String _name;
	
	protected List<Mark> _marks;
	
	public Student(String name, String surname, String groupName, List<Mark> marks) {
		_name = name;
		_surname = surname;
		_groupName = groupName;
		_marks = marks;
	}
	
	public double calculateAverageMark() {
		double average = 0;
		for(Mark mark : _marks) {
			average += mark.getRate();
		}
		average /= _marks.size();
		
		return average;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s, %s.", _name, _surname, _groupName);
	}
	
	public String getSurname() {
		return _surname;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getGroup() {
		return _groupName;
	}
	
	public List<Mark> getMarks() {
		return _marks;
	}
	
	public void setSurname(String surname) {
		_surname = surname;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public void setGroup(String group) {
		_groupName = group;
	}
	
	public void setMarks(List<Mark> marks) {
		_marks = marks;
	}
}
