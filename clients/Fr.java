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

	private BufferedReader in;

	private PrintWriter out;

	public void start() throws NotBoundException, UnknownHostException, IOException {
		Registry yasuo = LocateRegistry.getRegistry("127.0.0.1", 2023);
		Patient abdullah = (Patient) yasuo.lookup("chehri");

		// abdullah.push("ah","saha","manandnd","33");
		try {
			Socket client = new Socket("127.0.0.1", 9000);
			this.out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			InputHandler inHandler = new InputHandler();
			Thread t = new Thread(inHandler);
			t.start();
			String inMessage;
			while ((inMessage = in.readLine()) != null) {
				System.out.println(inMessage);
			}

		} catch (IOException error) {
			System.out.println(error.getMessage());
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

	public static void main(String[] args) throws UnknownHostException, NotBoundException, IOException {
		Fr client = new Fr();
		client.start();
	}

}
