package src.application;

import java.sql.Connection;
import java.util.Scanner;

import src.db.DB;
import src.db.connections.Connections;
import src.entities.Bank;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		
		Connections connec = new Connections(conn);

		System.out.println("Sign In | Sign Up");
		int n = 1;
		while (n != 0) {
			n = sc.nextInt();

			if (n == 1) {
				sc.nextLine();
				System.out.println("----LogIn----");

				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Password: ");
				String pass = sc.nextLine();
				
				String result = connec.logIn(name, pass);
		
				if (result != null) {
					
					Bank user_account = new Bank(conn, name, pass);
					
					int op = 1;
					while (op != 0) {
						System.out.println("0 | Exit");
						System.out.println("1 | Deposit");
						System.out.println("2 | Withdraw");

						op = sc.nextInt();
						if (op == 0) {
							return;
						}
						else if (op == 1) {
							System.out.println("Amount to deposit: $");
							Double amount = sc.nextDouble();
							
							user_account.deposit(amount);
						}
						else if (op == 2) {
							System.out.println("Amount to withdraw: $");
							Double amount = sc.nextDouble();
							
							user_account.withdraw(amount);
						}
					}
				}
				else {
					System.out.println("Error");
				}
				sc.close();
				return;
			} 
			else if (n == 2) {

				sc.nextLine();
				System.out.println("----Create User----");

				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Password: ");
				String pass = sc.nextLine();

				connec.createUser(name, pass);

				sc.close();
				return;
			}
		}

	sc.close();
	DB.closeConnection();

	}
}
/*
 * Connection conn = DB.getConnection(); Bank ba = new Bank(conn, "wanderson");
 * Double balance = ba.getBalance();
 * 
 * System.out.println(balance);
 * 
 * ba.deposit(500.0);
 * 
 * balance = ba.getBalance();
 * 
 * System.out.println(balance);
 * 
 * DB.closeConnection();
 */