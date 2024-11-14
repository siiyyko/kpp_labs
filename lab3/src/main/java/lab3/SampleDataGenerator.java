package lab3;

import java.time.LocalDateTime;
import java.util.List;

public class SampleDataGenerator {

	public static void generateWithNormalStreams() {
		UserProfile profile = new UserProfile(1, "Горнір", "Мейден", "hormay@example.com", List.of(
			    new Message("subj1", "important text1", LocalDateTime.now()),
			    new Message("subj2", "nonimportant text2", LocalDateTime.now())
			));

			UserProfileNormalIO.writeUserProfile(profile, "userProfile.ser");
	}
	
	public static void generateWithBufferedStreams() {
		UserProfile profile = new UserProfile(2, "Іван", "Петричук", "ivanp@example.com", List.of(
			    new Message("message1", "sample text1", LocalDateTime.now()),
			    new Message("message2", "sample text2", LocalDateTime.now())
			));

			UserProfileBufferedIO.writeUserProfile(profile, "userProfile.dat");
	}

	public static void generateWithJSON() {
		UserProfile profile = new UserProfile(3, "Денис", "Гудзенко", "hudzkid@example.com", List.of(
			    new Message("message1", "sample text123", LocalDateTime.now()),
			    new Message("message2", "sample text234", LocalDateTime.now())
			));
		UserProfileJsonIO.writeUserProfileToJson(profile, "userJsonProfile.json");
	}
	
	public static void generateWithYAML() {
		UserProfile profile = new UserProfile(4, "Артем", "Гуцул", "lemko@example.com", List.of(
			    new Message("message1", "java is cool", LocalDateTime.now()),
			    new Message("message2", "i love java", LocalDateTime.now())
			));
		UserProfileYamlIO.writeUserProfile(profile, "userYamlProfile.yaml");
	}
}
