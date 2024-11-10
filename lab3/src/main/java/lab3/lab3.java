package lab3;

public class lab3 {

	public static void main(String[] args) {
			SampleDataGenerator.generateWithStreams();
			
			var readProfile = UserProfileReader.readUserProfile(".\\userProfile.dat");
			
			Printer.print(readProfile);
			Printer.printList(readProfile.getMessages());
			
			UserProfile.flipSerializeMessagesFlag();
			
			SampleDataGenerator.generateWithJSON();
			var readJsonProfile = UserProfileJsonReader.readUserProfile(".\\userJsonProfile.json");
			Printer.print(readJsonProfile);
			Printer.printList(readJsonProfile.getMessages());
			
			SampleDataGenerator.generateWithYAML();
			var readYamlProfile = UserProfileYamlReader.readUserProfile(".\\userYamlProfile.yaml");
			Printer.print(readYamlProfile);
			Printer.printList(readYamlProfile.getMessages());
	}

}
