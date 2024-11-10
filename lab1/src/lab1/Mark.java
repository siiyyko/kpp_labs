package lab1;

public class Mark {

	private String _subject;
	private int _rate;
	
	public Mark(String subject, Integer rate) {
		setSubject(subject);
		setRate(rate);
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String _subject) {
		this._subject = _subject;
	}

	public int getRate() {
		return _rate;
	}

	public void setRate(int _rate) {
		this._rate = _rate;
	}

}
