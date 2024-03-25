package com.sathya.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JdbcCallableEx {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ravi","kumar");
		
		//call the procedure
		CallableStatement callableStatement=connection.prepareCall("{Call getSal(?,?)}");
		
		//set the input data
		callableStatement.setInt(1,1002);
		
		//register one variable to store the data
		callableStatement.registerOutParameter(2,Types.DOUBLE);
		
		//execute the procedure the output will be stored in register paramter
		callableStatement.executeUpdate();
		
		//print the output
		System.out.println(callableStatement.getFloat(2));
	}
}
