package src.db.connections;

import java.sql.Connection;

import src.db.DB;

public abstract class Connections {

	protected Connection conn;
	
	public Connections() {
		conn = DB.getConnection();
	}
	public Connections(Connection conn) {
		this.conn = conn;
	}

	public abstract String logIn(String usuario, String pass);

	public abstract void createUser(String usuario, String password);

}
