package demo_package;

import  java.sql.*;

import org.testng.annotations.Test;		


public class  SQLConnector {				
	//public static void  main(String[] args) throws  ClassNotFoundException, SQLException {
	@Test
	public void DBTest() throws ClassNotFoundException, SQLException {
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
		String dbUrl = "jdbc:mysql://localhost:3306/flight";					

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = "abhi";				

		//Query to Execute		
		String query = "select * from login;";	

		//Load mysql jdbc driver		
		Class.forName("com.mysql.jdbc.Driver");			

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
		Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
		while (rs.next()){
			String myName = rs.getString(1);								        
			String myAge = rs.getString(2);					                               
			System. out.println(myName+"  "+myAge);		
		}		
		// closing DB Connection		
		con.close();			
	}
}
