package socket;

import java.io.*;
import java.net.*;

public class AddClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("5");
        out.println("10");
        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}

// Problem 2: Create a server that calculates and returns the sum of two numbers sent by the client.

// Explanation: The server listens for incoming connections, reads two numberssent by the client, calculates their sum, and returns the result to the client.