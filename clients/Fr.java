package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import server.Patient;

public class Fr {
	public static void main(String[] args) throws NotBoundException, UnknownHostException, IOException {
		Registry yasuo = LocateRegistry.getRegistry("127.0.0.1", 2023);
		Patient abdullah = (Patient) yasuo.lookup("chehri");

		// abdullah.push("ah","saha","manandnd","33");
		Socket connection = new Socket("127.0.0.1", 4000);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		PrintWriter out = new PrintWriter(connection.getOutputStream());

		Scanner input = new Scanner(System.in);

		while (true) {
			String messageOut = input.nextLine();
			if (messageOut != null) {
				out.println(messageOut);
			}
			String messageIn = in.readLine();
			if (messageIn != null) {
				System.out.println(messageIn);
			}

		}
	}

}
