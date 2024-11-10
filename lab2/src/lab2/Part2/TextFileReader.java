package lab2.Part2;

import java.io.BufferedReader;
import java.io.FileReader;

public class TextFileReader {
	private String filePath;
	
	public TextFileReader(String _filePath) {
		filePath = _filePath;
	}
	
	public String read() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        StringBuilder content = new StringBuilder();
	        String line;

	        while ((line = reader.readLine()) != null) {
	            content.append(line).append("\n");
	        }

	        reader.close();
	        
	        String res = content.toString();
	        return res;
	        
		}
		catch (Exception e) {
			System.err.println("Error happened reading file. " + e.getMessage());
			return null;
		}
	}
	
}
