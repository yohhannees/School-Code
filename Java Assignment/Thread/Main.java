package Thread;
class HelloWorldThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello, World!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HelloWorldThread helloWorldThread = new HelloWorldThread();
        helloWorldThread.start();
    }
}

// Problem: Create a simple thread that prints "Hello, World!" five times.

// Explanation: In this example, we extend the Thread class and override the run() method. Inside the run() method, we place the code we want to execute in the thread. In this case, we print "Hello, World!" five times. In the main() method, we create an instance of the HelloWorldThread and start it.