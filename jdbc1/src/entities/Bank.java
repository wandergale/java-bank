package src.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.db.DB;

public class Bank {

	private String client;
	private String pass;

	private Connection conn = null;
	private PreparedStatement st = null;
	private Statement stm = null;
	private ResultSet result = null;

	public Bank() {
		conn = DB.getConnection();
	}

	public Bank(Connection conn, String client, String pass) {
		this.conn = conn;
		this.client = client;
		this.pass = pass;
	}

	public void deposit(Double amount) {
		try {
			String query = "UPDATE javabank SET client_balance" + "= client_balance + ?" + "WHERE "
					+ "(client_name = ?) AND (client_password = ?)";

			st = conn.prepareStatement(query);

			st.setDouble(1, amount);
			st.setString(2, this.client);
			st.setString(3, this.pass);

			st.execute();

			System.out.println("Success Deposit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Double getBalance() {

		try {
			String query = "SELECT * FROM javabank WHERE client_name = '" + this.client + "' AND client_password = '"
					+ this.pass + "'";
			stm = conn.createStatement();

			result = stm.executeQuery(query);

			if (result != null) {
				result.next();
				return result.getDouble("client_balance");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;
	}

	public void withdraw(Double amount) {
		if (this.getBalance() < amount) {
			System.out.println("insufficient funds");
			return;
		}
		try {
			String query = "UPDATE javabank SET client_balance" + "= client_balance - ?" + "WHERE "
					+ "(client_name = ?) AND (client_password = ?)";

			st = conn.prepareStatement(query);

			st.setDouble(1, amount);
			st.setString(2, this.client);
			st.setString(3, this.pass);

			st.execute();

			System.out.println("Success Withdraw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
