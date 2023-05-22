class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementThread thread1 = new IncrementThread(counter);
        IncrementThread thread2 = new IncrementThread(counter);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter: " + counter.getCount());
    }
}

// Problem: Create two threads that increment the same counter simultaneously and use synchronization to avoid race conditions.

// Explanation: In this example, we create a Counter class with a synchronized increment() method. The synchronization ensures that only one thread can access the method at a time, preventing race conditions. We create two threads that increment the counter simultaneously and synchronize their access to the increment() method. In the main() method, we start the threads, wait for them to finish, and then print the result.