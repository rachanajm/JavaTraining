package com.nttdatatraining.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Dbconnection {
	public static Connection getdatabaseconnection()
	{
    Connection con = null;
		
		try
		{
			Class.forName(Dbdetails.DRIVER_NAME);
			
			con = DriverManager.getConnection(Dbdetails.CONSTR, Dbdetails.USER_NAME,
					Dbdetails.PASSWORD);
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
 return con;
}
	
}
