package lab3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserProfileBufferedIO {
    public static void writeUserProfile(UserProfile profile, String filePath) {
        
    	try(ObjectOutputStream oos =
    			new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));) {
    		
            oos.writeObject(profile);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
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
