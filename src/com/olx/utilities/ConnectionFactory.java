package com.olx.utilities;

import java.sql.*;
public class ConnectionFactory {
	 public static Connection getConnection(){
		   Connection conn=null;
		   try{
				Class.forName("com.mysql.jdbc.Driver");
				String DB_URL = "jdbc:mysql://localhost:3306/olxdb";
				String USER = "root";
				String PASS = "root";
				 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
		}
}
