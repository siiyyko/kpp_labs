package lab3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserProfileJsonWriter {
	
    public static void writeUserProfileToJson(UserProfile profile, String filePath) {
        Gson gson = new GsonBuilder()
        		.excludeFieldsWithoutExposeAnnotation()
        		.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        		.setPrettyPrinting()
        		.create();
        
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(profile, writer);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}