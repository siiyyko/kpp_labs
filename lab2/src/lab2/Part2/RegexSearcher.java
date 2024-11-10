package lab2.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearcher {
	public static List<String> search(String text, String regex) {
		Pattern sentencePattern = Pattern.compile(regex);

        Matcher matcher = sentencePattern.matcher(text);

        List<String> strings = new ArrayList<String>();
        
        while (matcher.find()) {
        	strings.add(matcher.group());
        }
        
        return strings;
	}
}
