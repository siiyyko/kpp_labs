package lab3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.google.gson.annotations.Expose;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Expose
    private String subject;
    
    @Expose
    private String text;
    
    @Expose
    private LocalDateTime date;

    public Message(String subject, String text, LocalDateTime date) {
        this.subject = subject;
        this.text = text;
        this.date = date;
    }
    public Message() {
    	subject = null;
    	text = null;
    	date = LocalDateTime.now();
    }
    
    public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public String getSubject() { return subject; }
    public String getText() { return text; }
    public LocalDateTime getDate() { return date; }
    
    @Override
    public String toString(){
    	String prettyDate = date.truncatedTo(ChronoUnit.SECONDS).toString();
    	return String.format("%s: %s. %s\n", subject, text, prettyDate);
//    	return String.format("%s: %s (%s)\n", subject, text, 
//                date != null ? date.truncatedTo(ChronoUnit.SECONDS) : "No date");
    }
}
