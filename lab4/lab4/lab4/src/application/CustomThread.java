package application;

public class CustomThread {
	private int id;
	private String name;
	private String returnedResult;
	private String timeSpent;
	private String status;
	
	public CustomThread(int id, String name, String returnedResult, String timeSpent, String status) {
		this.id = id;
		this.name = name;
		this.returnedResult = returnedResult;
		this.timeSpent = timeSpent;
		this.setStatus(status);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReturnedResult() {
		return returnedResult;
	}
	public void setReturnedResult(String returnedResult) {
		this.returnedResult = returnedResult;
	}
	public String getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
