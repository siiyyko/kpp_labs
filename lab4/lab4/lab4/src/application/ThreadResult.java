package application;

public class ThreadResult {
    private final int id;
    private final String threadName;
    private final String updatedCell;
    private final String executionTime;

    public ThreadResult(int id, String threadName, String updatedCell, String executionTime) {
        this.id = id;
        this.threadName = threadName;
        this.updatedCell = updatedCell;
        this.executionTime = executionTime;
    }

    public int getId() {
        return id;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getUpdatedCell() {
        return updatedCell;
    }

    public String getExecutionTime() {
        return executionTime;
    }
}
