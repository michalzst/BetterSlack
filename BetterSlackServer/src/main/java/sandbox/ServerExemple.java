package sandbox;

import java.io.*;
import java.net.*;

public class ServerExemple {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    //private PrintWriter output;
    private BufferedReader input;
    private static final String EXIT_KEYWORD = "exit";


    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running...");
        clientSocket = serverSocket.accept();
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //output = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Client has been connected");

        while (!clientSocket.isClosed()) {
            String text = "";
            //output.println("Server response");
            try {
                text = input.readLine();
            } catch (SocketException ex) {
                System.out.println("Client has been disconnected");
                break;
            }
            if (text.toLowerCase().equals(EXIT_KEYWORD)) {
                break;
            }
            System.out.println(text);
        }
    }
}

