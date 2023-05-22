package Thread;

class SumThread implements Runnable {
    private int n;
    private long sum;

    public SumThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread = new SumThread(100);
        Thread thread = new Thread(sumThread);
        thread.start();
        thread.join();
        System.out.println("Sum: " + sumThread.getSum());
    }
}

// Problem: Create a thread that calculates the sum of the first n natural numbers.

// Explanation: In this example, we implement the Runnable interface instead of extending the Thread class. The reason we use the Runnable interface is to avoid the limitations of single inheritance in Java. We calculate the sum of the first n natural numbers in the run() method. In the main() method, we create an instance of the SumThread, wrap it in a Thread object, start the thread, wait for it to finish using join(), and then print the result.