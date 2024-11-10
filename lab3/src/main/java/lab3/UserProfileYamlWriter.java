package lab3;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;

public class UserProfileYamlWriter {

    public static void writeUserProfile(UserProfile profile, String filePath) {
    	
    	YAMLFactory yamlFactory = new YAMLFactory()
    			.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
    			.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
    			.enable(YAMLGenerator.Feature.INDENT_ARRAYS)
    			.enable(YAMLGenerator.Feature.LITERAL_BLOCK_STYLE);
    	
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDefaultPrettyPrinter(new MinimalPrettyPrinter());

        try {
            mapper.writeValue(new File(filePath), profile);
            System.out.println("UserProfile saved to YAML at " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving UserProfile to YAML: " + e.getMessage());
        }
    }
}
