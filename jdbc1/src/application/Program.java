package application;

import java.util.Scanner;

import db.connections.Connections;



public class Program {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connections conn = new Connections();
		
		System.out.println("Sign In | Sign Up");
		int n = 1;
		while (n != 1 || n != 2) {
			n = sc.nextInt();
			
			if (n == 1) {
				sc.nextLine();
				System.out.println("----Log In----");

				System.out.print("Name: ");
				String name = sc.nextLine();
				
				
				System.out.print("Password: ");
				String pass = sc.nextLine();
				
				String result = conn.logIn(name, pass);
				
				System.out.println(result);
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
				
				conn.createUser(name, pass);
				sc.close();
				
				return;
			}
		}
		
		sc.close();
	}
}
