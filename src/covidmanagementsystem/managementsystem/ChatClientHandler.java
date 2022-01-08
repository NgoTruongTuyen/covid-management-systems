package covidmanagementsystem.managementsystem;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientHandler implements Runnable {

    // runnable for each client thread
    private Socket client;
    private Server server;
    private Scanner inputStream;

    public ChatClientHandler(Socket client, Server server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(client.getInputStream());
            while (true) {
                if (!inputStream.hasNext()) {
                    return;
                }
                String chatLine = inputStream.nextLine();
                //System.out.println(client.getRemoteSocketAddress() + " said: " + chatLine);
                server.sendChatMessageToAll(chatLine);
                //System.out.println("----------------" + chatLine + "------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
