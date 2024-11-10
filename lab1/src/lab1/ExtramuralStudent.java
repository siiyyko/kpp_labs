package lab1;

import java.util.ArrayList;

public class ExtramuralStudent extends Student {

	private String _workplace;
	
	public ExtramuralStudent(String name, String surname, String group, String workplace, ArrayList<Mark> marks) {
		super(name, surname, group, marks);
		_workplace = workplace;
	}

	@Override
	public String toString() {
		return String.format("%s %s, %s, Workplace: %s.", _name, _surname, _groupName, _workplace);
	}
	
	public String getWorkplace() {
		return _workplace;
	}
	
	public void setWorkplace(String workplace) {
		_workplace = workplace;
	}
}
