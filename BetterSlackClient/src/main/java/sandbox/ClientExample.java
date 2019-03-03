package sandbox;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
    private Socket socket;
    private PrintWriter output;
    //private BufferedReader input;
    private Scanner scanner;
    private static final String EXIT_KEYWORD="exit";

    public void connecToServer(String ipAddress, int port) throws IOException{
        socket = new Socket(ipAddress,port);
        //input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(),true);
        scanner = new Scanner(System.in);
        while (true){
            String text = scanner.next();
            output.println(text);
            //System.out.println(input.readLine());
            if (text.toLowerCase().equals(EXIT_KEYWORD)){
                break;
            }
        }

    }
}
