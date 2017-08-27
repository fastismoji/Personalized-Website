package com.gmu.rmohod.databasemodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class to establish connection with database
 * 
 * @author Rasika
 *
 */
public class DatabaseConnection {
	/**
	 * Method to establish database connection
	 * 
	 * @return Connection object
	 */
	public Connection getDBConnetion(){  
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","rmohod","oadroa");  

			//step3 create the statement object  
			Statement stmt=con.createStatement();  

			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from STUDENTINFO");
			
			System.out.println("Table is: \n");
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  

			//step5 close the connection object  
			//con.close();  
			
			//return the connection object
			return con;

		}catch(Exception e){ 
			System.out.println(e);
		}
		
		return null;  

	}  
	
	public static void main(String args[]){  
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","rmohod","oadroa");  

			//step3 create the statement object  
			Statement stmt=con.createStatement();  

			String studentId = "GMU003";
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENTINFO WHERE STUDENTID = '"+studentId+"'");
			
			ArrayList<String> studentsIds =  new ArrayList<String>();
			int i=0;
			
			//store the retrieved student Ids
			while(rs.next()) {
				studentsIds.add(rs.getString(1));
				System.out.println(studentsIds.get(i));
				i++;
			}  

			//step5 close the connection object  
			con.close();  

		}catch(Exception e){ System.out.println(e);}  

	}  
}
