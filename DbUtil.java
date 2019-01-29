package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	
	static Connection conn=null;
	//static factory
	
	
	public static Connection getDbConnection() {
	String url ="jdbc:oracle:thin:@10.219.34.3:1521/orcl";
	String un  ="trg217";
	String pass="training217";
	
	try
	{
		
		conn=DriverManager.getConnection(url, un, pass);
	}
	catch(SQLException e)
	{
		System.out.println("connection problem :: " + e.getMessage());
	}
	/*finally {
		try {
				if(conn!=null)
			     conn.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("unable to close the connection...."+ e.getMessage());
		}*/
	return conn;
	
}

}
