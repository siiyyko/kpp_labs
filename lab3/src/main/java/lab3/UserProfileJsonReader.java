package lab3;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserProfileJsonReader {

	public static UserProfile readUserProfile(String filePath) {
		 Gson gson = new GsonBuilder()
//				 .excludeFieldsWithoutExposeAnnotation()
				 .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
				 .create();
	        try (FileReader reader = new FileReader(filePath)) {
	            return gson.fromJson(reader, UserProfile.class);
	        } catch (IOException e) {
	            System.err.println(e.getMessage());
	            return null;
	        }
	}

	
}

