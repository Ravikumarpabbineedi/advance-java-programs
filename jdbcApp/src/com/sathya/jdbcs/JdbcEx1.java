package com.sathya.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		//step1:load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver loaded successfully...");
		
		//step-2:create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","ravi","kumar");
		System.out.println("jdbc connected successfully...");
		
		//step-3:process
		String query="create table emp(empid number,empname varchar2(30),empsalary number)";
		Statement statement=connection.createStatement();
		int result=statement.executeUpdate(query);
		System.out.println("Table created successffully...="+result);
		//step-4:close the connection
		connection.close();
		System.out.println("connection closed successfully...");
	}
}
