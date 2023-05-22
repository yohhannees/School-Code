package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Date date = new Date();
            out.println(date.toString());

            clientSocket.close();
        }
    }
}