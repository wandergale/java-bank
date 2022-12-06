package src.db.connections;

import java.sql.Connection;

public class NoSQL extends Connections {
	
	public NoSQL() {
		super();
	}
	public NoSQL(Connection conn) {
		super(conn);
	}

	@Override
	public String logIn(String usuario, String pass) {
		return pass;
	}
	
	@Override
	public void createUser(String usuario, String password) {
		// ...
	}


}
