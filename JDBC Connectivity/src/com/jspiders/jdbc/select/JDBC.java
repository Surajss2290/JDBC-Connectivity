package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {
	
	public static void main(String[] args) {
		
		//1.Load Driver Class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //this line throws ClassNotFoundException
			//Class.forName() is used to connect two classes. 
			
		//2. Open Connections
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja1?"+"user=root&password=root");
			//DriveManager acts as an interface between Java application and drivers.
			
		//3. Create Statements
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from student");
			
		//4.Process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+ resultSet.getString(2)+"||"
						+ resultSet.getString(3)+"||"
						+ resultSet.getLong(4));
			}
			
		//5.Close Connections
			connection.close();
			statement.close();
			resultSet.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}