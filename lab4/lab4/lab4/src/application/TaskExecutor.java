package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {
	private final ThreadPoolExecutor pool;
    private final int numThreads;
    private final int tasksNum = 100;
    private final int maxSize = 14;

    public TaskExecutor(int numThreads) {
        this.numThreads = numThreads;
        this.pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
    }

    public List<Future<ThreadResult>> submitTasks(Playfield playfield) {
        List<Future<ThreadResult>> futures = new ArrayList<>();
        int step = (int) (tasksNum / numThreads);
        for (int i = 0; i < numThreads - 1; i++) {
            int taskId = i, beg, end;
            
            beg = i*step;
            end = (i+1)*step - 1;
            
            futures.add(pool.submit(new CustomTask(taskId, maxSize, beg, end)));
        }
        int taskId = numThreads-1;
        int beg = taskId*step;
        int end = tasksNum-1;
        futures.add(pool.submit(new CustomTask(taskId, maxSize, beg, end)));
        return futures;
    }

    public void shutdown() {
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
