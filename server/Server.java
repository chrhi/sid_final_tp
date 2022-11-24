package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    Patient rukia;

    void start() throws Exception {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");

        HandlePatient abdullah = new HandlePatient();
        System.out.println("the server is running on port 2023");
        rukia = (Patient) UnicastRemoteObject.exportObject(abdullah, 1);
        Registry registry = LocateRegistry.createRegistry(2023);
        registry.bind("chehri", rukia);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }
}
