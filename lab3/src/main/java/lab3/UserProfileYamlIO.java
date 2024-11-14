package lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;

public class UserProfileYamlIO {

    public static void writeUserProfile(UserProfile profile, String filePath) {
    	
    	YAMLFactory yamlFactory = new YAMLFactory()
                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)      // Remove "---" from start
                .enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)              // Reduce unnecessary quotes
                .enable(YAMLGenerator.Feature.INDENT_ARRAYS)                // Format arrays in YAML style
                .enable(YAMLGenerator.Feature.LITERAL_BLOCK_STYLE);         // Literal block style for strings
        
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            mapper.writeValue(new File(filePath), profile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static UserProfile readUserProfile(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        mapper.registerModule(new JavaTimeModule());

        try {
            return mapper.readValue(new File(filePath), UserProfile.class);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
