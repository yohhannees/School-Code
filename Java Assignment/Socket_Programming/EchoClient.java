package Socket_Programming;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello, server!");
        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}

// Problem: Create a server that echoes back any message sent by the client.

// Explanation: The server listens for incoming connections, reads the client's message, and sends the same message back to the client. The client sends a message to the server and waits for the response.