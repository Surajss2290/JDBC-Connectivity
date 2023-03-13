package com.jspiders.jdbc.select;



import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

class JDBCselectDemo5{
	private static Connection connection;
	private static java.sql.Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filepath="D:\\WEJA1\\JDBC Connectivity\\resource\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
             //Load Driver class
			Class.forName(properties.getProperty("driverpath"));
			
             //Open connection	
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
              //Create Statement
			statement=connection.createStatement();
			resultSet=statement.executeQuery(properties.getProperty("query"));
			
            //Result Process
			while(resultSet.next()) {
		    	System.out.println(resultSet.getString(2)+"||"
		    			+resultSet.getString(3)+"||"
		    			+resultSet.getString(4));
		    	
		    }
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		finally {
			 {
				try {
					if (connection!=null)
					connection.close();
					
					if (statement!=null) {
						statement.close();
					}
					if (resultSet!=null) {
						resultSet.close();
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
	
}