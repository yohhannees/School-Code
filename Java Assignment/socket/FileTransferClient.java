package socket;

import java.io.*;
import java.net.*;

public class FileTransferClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);
        byte[] fileBytes = new byte[1024 * 1024];

        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("received_example.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int bytesRead;
        while ((bytesRead = inputStream.read(fileBytes)) != -1) {
            bos.write(fileBytes, 0, bytesRead);
        }

        bos.flush();
        socket.close();
    }
}