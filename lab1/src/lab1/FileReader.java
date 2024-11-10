package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	private File fileToRead;
	
	FileReader(String pathToFile){
		fileToRead = new File(pathToFile);
	}
	
	public ArrayList<String> readFile(){
		ArrayList<String> strings = new ArrayList<String>();
		
		try {
			Scanner reader = new Scanner(fileToRead);
			while(reader.hasNextLine()) {
				strings.add(reader.nextLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		}
		
		return strings;
	}
}
