package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class RandomNumberServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Random random = new Random();
            int randomNumber = random.nextInt(100);

            out.println(randomNumber);

            clientSocket.close();
        }
    }
}
