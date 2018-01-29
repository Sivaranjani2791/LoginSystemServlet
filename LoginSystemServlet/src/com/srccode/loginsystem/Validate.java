package com.srccode.loginsystem;
import java.sql.*;

public class Validate {
	
	     public static boolean checkUser(String email,String passwrd) 
	     {
	      boolean st =false;
	      try{

		 //loading drivers for mysql
	         Class.forName("com.mysql.jdbc.Driver");

	 	 //creating connection with the database 
	         Connection con=DriverManager.getConnection
	                        ("jdbc:mysql:/ /localhost:3306/loginfrm","root","root");
	         PreparedStatement ps =con.prepareStatement
	                             ("select * from form where email=? and password=?");
	         ps.setString(1, email);
	         ps.setString(2, passwrd);
	         ResultSet rs =ps.executeQuery();
	         st = rs.next();
	        
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	      }
	         return st;                 
	  }   
	}


