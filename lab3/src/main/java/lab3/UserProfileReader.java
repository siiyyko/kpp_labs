package lab3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UserProfileReader {
    public static UserProfile readUserProfile(String filePath) {
        
    	try (ObjectInputStream ois =
        		new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
        	UserProfile profile = (UserProfile)ois.readObject();

            return profile;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
