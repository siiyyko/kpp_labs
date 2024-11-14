package lab3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

@JsonIgnoreProperties({"serializeMessages" })
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Expose
    private int id;

	@Expose
    private String firstName;
    
    @Expose
    private String lastName;
    
    @Expose
    private transient String email; 
    
    @Expose
    private List<Message> messages;
    
    private transient static boolean serializeMessages = true;

    public UserProfile(int id, String firstName, String lastName, String email, List<Message> messages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.messages = messages;
    }
    
    public UserProfile() {
        id = 0;
        firstName = null;
        lastName = null;
        email = null;
        messages = null;
      }
    
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public List<Message> getMessages() { return messages; }
    public boolean getSerializeMessages() { return serializeMessages; }
    
    public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
    
    @Override
    public String toString() {
		return String.format("%d: %s %s, %s", id, firstName, lastName, email);
    }
    
    public static void flipSerializeMessagesFlag() {
    	serializeMessages = !serializeMessages;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
    	if(!serializeMessages) {
            List<Message> originalMessages = messages;
            messages = List.of();
            out.defaultWriteObject();
            messages = originalMessages;
            out.writeObject(email); 
    	}
    	else {
    		out.defaultWriteObject();
    	}
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if(!serializeMessages) {
        	messages = List.of();
        	email = (String) in.readObject();
        }
    }
}

