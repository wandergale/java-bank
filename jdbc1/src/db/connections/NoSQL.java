package src.db.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NoSQL extends Connections {

	private Connection conn;
	private PreparedStatement st;
	private Statement stm;
	private ResultSet result;
	
	public NoSQL() {
		super();
	}
	public NoSQL(Connection conn) {
		super(conn);
	}

	public String logIn(String usuario, String pass) {
		return pass;
	}

	public void createUser(String usuario, String password) {
	}

}
