package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintTask implements Runnable {
    private final int taskId;

    public PrintTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
    }
}

public class Main4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            executor.execute(new PrintTask(i));
        }
        executor.shutdown();
    }
}

// Problem: Create a thread pool with a fixed number of threads and use them to execute tasks.

// Explanation: In this example, we use the ExecutorService interface to create a thread pool with a fixed number of threads. We create a PrintTask class that implements Runnable, which just prints the task ID and the name of the thread executing it. In the main() method, we create an ExecutorService with three threads, execute10 tasks, and then shut down the executor when all tasks are complete.