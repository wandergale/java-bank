package src.db.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL extends Connections {

	private PreparedStatement st = null;
	private Statement stm = null;
	private ResultSet result = null;
	
	public SQL() {
		super();
	}
	public SQL(Connection conn) {
		super(conn);
	}
	
	@Override
	public String logIn(String usuario, String pass) {
		
		try {			
			String query = "SELECT client_name FROM javabank WHERE client_name = '"
					+usuario+"' AND client_password = '"
					+pass+"'";
			stm = conn.createStatement();
			
			result = stm.executeQuery(query);
			
			if (result != null) {
				result.next();
				return result.getString("client_name");				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public void createUser(String usuario, String password) {
		try {
			st = conn.prepareStatement(
					"INSERT INTO javabank" + "(client_name, client_balance, client_password)" + "VALUES (?, ?, ?)");
			st.setString(1, usuario);
			st.setDouble(2, 0.0);
			st.setString(3, password);

			st.executeUpdate();

			System.out.println("User created");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
