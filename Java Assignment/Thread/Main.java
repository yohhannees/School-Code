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