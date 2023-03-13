package com.jspiders.jdbc.select;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCselectDemo3 {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverpath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja1";
	private static String user="root";
	private static String password="root";
	private static String query;
	
	public static void main(String[] args) {

		try {
            //Load the Driver Class
			Class.forName(driverpath);
			
			//open Connection
			Connection connection=DriverManager.getConnection(dburl,user,password);
			
           // create Statement
		     java.sql.Statement statement=connection.createStatement();
		     query="select * from student";
		     ResultSet resultSet=statement.executeQuery(query);

//		     Process Result
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
	
