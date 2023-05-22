package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FactorialTask implements Callable<Long> {
    private int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    public Long call() {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

public class Main5 {
    public static <T> void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> factorialFuture = (Future<Long>) executor.submit((Callable<T>) new FactorialTask(10));
        executor.shutdown();
        System.out.println("Factorial: " + factorialFuture.get());
    }
}

// Problem: Create a thread that calculates the factorial of a number and returns the result.

// Explanation: In this example, we use the Callable interface instead of Runnable because we need to return a value from the thread. We create a FactorialTask class that calculates the factorial of a number and returns the result. In the main() method, we create an ExecutorService with a single thread, submit the task, and retrieve the result using a Future object. Finally, we print the factorial and shut down the executor.