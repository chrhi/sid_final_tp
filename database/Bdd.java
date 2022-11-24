package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bdd {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	Bdd() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost/sid_expose", "root", "");

	}

	public void push(String firstName, String lastName, String day, String deg) throws SQLException {
		this.pst = con.prepareStatement("insert into patient(day,first_name,last_name,temp)values(?,?,?,?)");
		pst.setString(1, day);
		pst.setString(2, firstName);
		pst.setString(3, lastName);
		pst.setString(4, deg);
		pst.executeUpdate();
	}

	public ResultSet getData() throws SQLException {
		pst = con.prepareStatement("select * from patient");
		rs = pst.executeQuery();
		return rs;
	}

}