package com.jspiders.jdbc.select;

import java.io.FileNotFoundException;
//import java.beans.Statement;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCselectDemo4 {

	private static Connection connection;
	private static java.sql.Statement  statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String driverpath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja1";
	private static String filepath="D:\\WEJA1\\JDBC Connectivity\\resource\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {

		try {
            //Load the Driver Class
			Class.forName(driverpath);
			
			try {
				fileReader=new FileReader(filepath);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			properties=new Properties();
			try {
				properties.load(fileReader);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			//open Connection
			Connection connection=DriverManager.getConnection(dburl,properties);
			
           // create Statement
		     statement=connection.createStatement();
		     query="select * from student";
		     ResultSet resultSet=statement.executeQuery(query);

            //Process Result
		    while(resultSet.next()) {
		    	System.out.println(resultSet.getString(1)+"||"
		    			+resultSet.getString(2)+"||"
		    			+resultSet.getString(3)+"||"
		    			+resultSet.getString(4));
		    	
		    }
		     
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if (connection!=null) {
					connection.close();
					}
					if (statement!=null) {
						((java.sql.Statement) statement).close();
					}
					if (resultSet!=null) {
						resultSet.close();
					}
					
					}catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		
}
