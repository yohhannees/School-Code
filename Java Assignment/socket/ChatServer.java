package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<String> usernames = new HashSet<>();
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Chat Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Handler(clientSocket).start();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private String username;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMIT_USERNAME");
                    username = in.readLine();
                    if (username != null && !usernames.contains(username)) {
                        usernames.add(username);
                        writers.add(out);
                        out.println("USERNAME_ACCEPTED");
                        break;
                    }
                }

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        if (writer != out) {
                            writer.println(username + ": " + input);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                if (username != null) {
                    usernames.remove(username);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}