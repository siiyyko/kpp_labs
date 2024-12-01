package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class CustomTask implements Callable<ThreadResult> {
    private final int id;
    private final int maxSize;
    private final int beg_file_index;
    private final int end_file_index;

    public CustomTask(int id, int maxSize, int beg, int end) {
        this.id = id;
        this.maxSize = maxSize;
		this.beg_file_index = beg;
		this.end_file_index = end;
    }
    
    private char generateRandomChar() {
    	Random rand = new Random();
    	char charToFind = (char) ('a' + rand.nextInt(26));
    	return charToFind;
    }
    
    private int countLetter(String text, char letter) {
    	 int count = 0;
         for (char c : text.toCharArray()) {
             if (c == letter) {
                 count++;
             }
         }
         
         return count;
    }
    
    private List<Integer> processText(String text) {
    	List<Integer> pair = new ArrayList<Integer>();
    	text = text.toLowerCase();
    	char firstChar = generateRandomChar();
    	char secondChar = generateRandomChar();
    	
    	int x = countLetter(text, firstChar) % maxSize;
    	int y = countLetter(text, secondChar) % maxSize;
    	
    	pair.add(x);
    	pair.add(y);
    	
    	return pair;
    }
    
    @Override
    public ThreadResult call() {
    	long startTime = System.nanoTime();
        TextFileReader tfr = new TextFileReader("D:\\oleksii\\uni\\3COURSE\\1TERM\\KPP\\lab4-data\\data", "file-");
        
        String text;
        List<Integer> res = new ArrayList<Integer>();
        try {
			text = tfr.read(beg_file_index, end_file_index);
			res = processText(text);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
        
        try {
//            Thread.sleep(random.nextInt(2000));
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000_000.0;
        return new ThreadResult(id, Thread.currentThread().getName(), res.get(0) + "-" + res.get(1), String.format("%.3fs", executionTime));
    }
}
