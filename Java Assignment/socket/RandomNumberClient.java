package socket;

import java.io.*;
import java.net.*;

public class RandomNumberClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}
// Problem 3: Create a server that sends a random number to the client.

// Explanation: The server listens for incoming connections and sends a random number when the client connects.