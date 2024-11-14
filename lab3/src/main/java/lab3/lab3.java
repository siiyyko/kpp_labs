package lab3;

public class lab3 {

	public static void main(String[] args) {
			
			SampleDataGenerator.generateWithNormalStreams();
			
			var readNormalProfile = UserProfileNormalIO.readUserProfile(".\\userProfile.ser");
			Printer.print(readNormalProfile);
			Printer.printList(readNormalProfile.getMessages());
		
			UserProfile.flipSerializeMessagesFlag();
			SampleDataGenerator.generateWithBufferedStreams();
			
			var readBufferedProfile = UserProfileBufferedIO.readUserProfile(".\\userProfile.dat");
			
			Printer.print(readBufferedProfile);
			Printer.printList(readBufferedProfile.getMessages());
			
			UserProfile.flipSerializeMessagesFlag();
			
			SampleDataGenerator.generateWithJSON();
			var readJsonProfile = UserProfileJsonIO.readUserProfile(".\\userJsonProfile.json");
			Printer.print(readJsonProfile);
			Printer.printList(readJsonProfile.getMessages());
			
			SampleDataGenerator.generateWithYAML();
			var readYamlProfile = UserProfileYamlIO.readUserProfile(".\\userYamlProfile.yaml");
			Printer.print(readYamlProfile);
			Printer.printList(readYamlProfile.getMessages());
	}

}
