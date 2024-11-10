package lab3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class UserProfileWriter {
    public static void writeUserProfile(UserProfile profile, String filePath) {
        
    	try(ObjectOutputStream oos =
    			new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));) {        	
            oos.writeObject(profile);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
