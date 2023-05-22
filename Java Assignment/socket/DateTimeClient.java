package socket;

import java.io.*;
import java.net.*;

public class DateTimeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}

// Problem 1: Create a server that returns the current date and time to the client.

// Explanation: The server listens for incoming connections and returns the current date and time when the client connects.