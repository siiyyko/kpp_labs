package lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserProfileNormalIO {
	public static void writeUserProfile(UserProfile profile, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(profile);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
	
	public static UserProfile readUserProfile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            UserProfile profile = (UserProfile) ois.readObject();
            return profile;
        } catch (IOException | ClassNotFoundException e) {
        	System.err.println(e);
            return null;
        }
    }
}
