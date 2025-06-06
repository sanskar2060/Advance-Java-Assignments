package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment1 {

	public static final String url = "jdbc:mysql://127.0.0.1:3306/advancejava";
	public static final String userName = "root";

	public static final String pswd = "Gp25086@,";

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Scanner sc = new Scanner(System.in); Connection cn = DriverManager.getConnection(url, userName, pswd);) {
			PreparedStatement pst = null;
			while (true) {
				System.out.println("Enter choice");
				System.out.println("1.Register a user");
				System.out.println("2. List all users based on city");
				System.out.println("3. Update password of a user");
				System.out.println("4. Display user info based on username");
				System.out.println("5. Exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {

					String query = "insert into users(username,name,password,email,city) " + "values (?, ?, ?, ?, ?)";
					System.out.println("Enter username");
					String username = sc.next();

					System.out.println("Enter name");
					String name = sc.next();

					System.out.println("Enter password");
					String pwd = sc.next();

					System.out.println("Enter email");
					String email = sc.next();

					System.out.println("Enter city");
					String city = sc.next();

					pst = cn.prepareStatement(query);
					pst.setString(1, username);
					pst.setString(2, name);
					pst.setString(3, pwd);
					pst.setString(4, email);
					pst.setString(5, city);

					pst.executeUpdate();
					System.out.println("Entery added successfully...");
					break;
				}
				case 2: {

					String query = "select * from users where city = ?";
					System.out.println("Enter city");
					String city = sc.next();

					pst = cn.prepareStatement(query);
					pst.setString(1, city);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						System.out.println(rs.getInt("id"));
						System.out.println(rs.getString("username"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getString("password"));
						System.out.println(rs.getString("email"));
						System.out.println(rs.getString("city"));
						System.out.println("***********value retrieved successfully");
					}

					break;
				}
				case 3: {

					String query = "update users set password = ? where userName = ? ";

					System.out.println("enter user name");

					String userName = sc.next();

					System.out.println("enter password ");

					String password = sc.next();

					pst = cn.prepareStatement(query);
					pst.setString(1, password);
					pst.setString(2, userName);


					pst.executeUpdate();

					System.out.println("password updated successfully");

					break;
				}
				case 4: {
					String query = "select * from users where username = ?";
					System.out.println("Enter username");
					String username = sc.next();

					pst = cn.prepareStatement(query);
					pst.setString(1, username);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						System.out.println(rs.getInt("id"));
						System.out.println(rs.getString("username"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getString("password"));
						System.out.println(rs.getString("email"));
						System.out.println(rs.getString("city"));
						System.out.println("***********value retrieved successfully");
					}

					break;
				}
				case 5:
					System.exit(0);
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
