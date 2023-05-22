package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 5050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        out.println(username);

        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readLine();
                    if (message != null) {
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
            out.println(message);
        }
    }
}

// Problem: Create a simple TCP chat application where multiple clients can connect to a server and send messages to each other.

// Explanation: The server maintains a list of connected clients and relays messages received from one client to all other clients. When a client connects, it sends a username to the server to identify itself.