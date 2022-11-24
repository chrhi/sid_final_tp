package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

public interface Patient extends Remote {

    // this function will handle inserting new patient
    public void push(String firstName, String lastName, String day, String deg) throws RemoteException;

    // this function will handle getting all the data from the database

    public ResultSet selectAll() throws RemoteException;

}
