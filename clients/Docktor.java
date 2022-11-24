package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Docktor {
    ServerSocket provider;
    Socket connection;
    BufferedReader in;
    PrintWriter out;

    void start() throws IOException {
        provider = new ServerSocket(4000);

        connection = provider.accept();
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        out = new PrintWriter(connection.getOutputStream(), true);

        Scanner input = new Scanner(System.in);

        while (true) {
            String messageIn = in.readLine();
            if (messageIn != null) {
                System.out.println(messageIn);
            }

            String messageout = input.nextLine();
            if (messageout != null) {
                out.println(messageout);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Docktor docktor = new Docktor();
        docktor.start();
    }

}
