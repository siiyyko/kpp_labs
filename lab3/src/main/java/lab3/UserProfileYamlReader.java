package lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class UserProfileYamlReader {

    public static UserProfile readUserProfile(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.registerModule(new JavaTimeModule());

        try {
            return mapper.readValue(new File(filePath), UserProfile.class);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
