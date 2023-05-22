package socket;

import java.io.*;
import java.net.*;

public class AddServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String input1 = in.readLine();
            String input2 = in.readLine();
            int sum = Integer.parseInt(input1) + Integer.parseInt(input2);

            out.println(sum);

            clientSocket.close();
        }
    }
}