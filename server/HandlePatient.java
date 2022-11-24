package server;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Bdd;

public class HandlePatient implements Patient {

    private Bdd db;

    HandlePatient() throws ClassNotFoundException, SQLException {
        db = new Bdd();
    }

    @Override
    public void push(String firstName, String lastName, String day, String deg) throws RemoteException {
        try {
            db.insert(firstName, lastName, day, deg);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }

    }

    @Override
    public ResultSet selectAll() throws RemoteException {
        try {
            ResultSet results = db.selectAll();
            return results;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

}
