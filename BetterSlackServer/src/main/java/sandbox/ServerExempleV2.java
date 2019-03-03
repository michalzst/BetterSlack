package sandbox;

import java.io.BufferedReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerExempleV2{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader input;
    private static final String EXIT_KEYWORD = "exit";
    private List<Socket> connectedList = new ArrayList<Socket>();
    private boolean online;
    Thread acceptingThread;

    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running...");
        online = true;

        acceptingThread = new Thread(() -> {
            Socket clientSocket = null;
            while (online) {
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    online = false;
                    System.out.println("Server has been disconnected.");
                    break;
                }
                connectedList.add(clientSocket);
                System.out.println("Client has been connected. " + "Users online: " + connectedList.size());
            }
            System.out.println("Server has been disconnected.");
        });
        acceptingThread.start();


    }

    public void shutdown() {
        online = false;
    }

    public boolean isOnline() {
        return online;
    }
}


