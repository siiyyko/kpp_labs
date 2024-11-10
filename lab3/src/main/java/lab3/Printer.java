package lab3;

import java.util.List;

public class Printer {
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	public static void printList(List<Message> readMessages) {
		StringBuilder str = new StringBuilder();
		for(var o: readMessages) {
			str.append(o.toString());
		}
		System.out.println(str.toString());
	}
}
