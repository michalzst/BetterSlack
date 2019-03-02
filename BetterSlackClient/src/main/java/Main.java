import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientExample clientExample = new ClientExample();
        clientExample.connecToServer("localhost",65535);

    }
}
