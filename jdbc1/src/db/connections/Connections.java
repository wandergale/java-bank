package src.db.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.db.DB;

public class Connections {

	protected Connection conn;
	
	public Connections() {
		conn = DB.getConnection();
	}
	public Connections(Connection conn) {
		this.conn = conn;
	}

	public String logIn(String usuario, String pass) {
		return pass;
	}

	public void createUser(String usuario, String password) {
	}

}
