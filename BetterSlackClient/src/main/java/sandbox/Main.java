package sandbox;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientExample clientExample = new ClientExample();
        clientExample.connecToServer("192.168.1.74",55555);

    }
}
