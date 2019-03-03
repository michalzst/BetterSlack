import Sandbox.ServerExemple;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerExemple serverExemple = new ServerExemple();
        serverExemple.startServer(65535);

    }
}
