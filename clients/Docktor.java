package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;

public class Docktor {

    ServerSocket server;
    Socket client;
    private BufferedReader in;

    private PrintWriter out;

    public void start() throws NotBoundException, IOException {
        this.server = new ServerSocket(9000);
        this.client = this.server.accept();
        this.out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        InputHandler inHandler = new InputHandler();
        Thread t = new Thread(inHandler);
        t.start();
        String inMessage;
        while ((inMessage = in.readLine()) != null) {
            System.out.println(inMessage);
        }

    }

    class InputHandler implements Runnable {

        @Override
        public void run() {
            try {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String message = inReader.readLine();
                    if (message != null) {
                        out.println(message);
                    }
                }

            } catch (IOException err) {
                System.out.println(err.getMessage());
            }

        }

    }

    public static void main(String[] args) throws NotBoundException, IOException {
        Docktor salah = new Docktor();
        salah.start();
    }
}
