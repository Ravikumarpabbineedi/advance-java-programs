package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

	public static void main(String[] args) throws SQLException{
		Connection connection=null;
		Statement statement=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ravi","kumar");
		
		statement=connection.createStatement();
		
		connection.setAutoCommit(false);
		
		statement.executeUpdate("create table tickets(price number,movie varchar2(20))");
		statement.executeUpdate("insert into tickets values(853,'kp')");
		statement.executeUpdate("insert into tickets values(850,'prr')");
		
		connection.commit();
		System.out.println("success");
		}
		catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("fail");
			connection.rollback();
			e.printStackTrace();
		}
		finally {
			//System.out.println(connection.isClosed());
			if(connection!=null) connection.close();
			if(statement!=null) statement.close();
		}
	}

}
