package socket;

import java.io.*;
import java.net.*;

public class FileTransferServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("File Transfer Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            File file = new File("example.txt");
            byte[] fileBytes = new byte[(int) file.length()];

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(fileBytes, 0, fileBytes.length);

            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(fileBytes, 0, fileBytes.length);
            outputStream.flush();

            clientSocket.close();
        }
    }
}

// Problem: Create a server and client for transferring a file.

// Explanation: The server listens for incoming connections and sends a file to the client when a connection is established. The client connects to the server, receives the file, and saves it locally.