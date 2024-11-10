package lab3;

import java.time.LocalDateTime;
import java.util.List;

public class SampleDataGenerator {

	public static void generateWithStreams() {
		UserProfile profile = new UserProfile(1, "Іван", "Петричук", "ivanp@example.com", List.of(
			    new Message("message1", "sample text1", LocalDateTime.now()),
			    new Message("message2", "sample text2", LocalDateTime.now())
			));

			UserProfileWriter.writeUserProfile(profile, "userProfile.dat");
	}

	public static void generateWithJSON() {
		UserProfile profile = new UserProfile(2, "Денис", "Гудзенко", "hudzkid@example.com", List.of(
			    new Message("message1", "sample text123", LocalDateTime.now()),
			    new Message("message2", "sample text234", LocalDateTime.now())
			));
		UserProfileJsonWriter.writeUserProfileToJson(profile, "userJsonProfile.json");
	}
	
	public static void generateWithYAML() {
		UserProfile profile = new UserProfile(3, "Артем", "Гуцул", "lemko@example.com", List.of(
			    new Message("message1", "java is cool", LocalDateTime.now()),
			    new Message("message2", "i love java", LocalDateTime.now())
			));
		UserProfileJsonWriter.writeUserProfileToJson(profile, "userYamlProfile.yaml");
	}
}
