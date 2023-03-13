package com.jspiders.jdbc.Update;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUpdateDemo {
	private static Connection connection;
	private static java.sql.Statement statement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filepath="D:\\WEJA1\\JDBC Connectivity\\resource\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		try {
			//Read the file
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			//Load Driver class
			Class.forName(properties.getProperty("driverpath"));
			//open connection
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			//Create statement
			statement=connection.createStatement();			
           //Execute statement
			query="update student"+" set email=' jetagadha@gmail.com '"+"where id=4";
			
           //Execute result
		result=statement.executeUpdate(query);
			
			System.out.println("Query ok "+result+" rows affected");
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if (connection!=null)
				connection.close();
				
				if (statement!=null) {
					statement.close();
				}
				
				if (fileReader!=null) {
					fileReader.close();
					
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
