package com.sathya.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JdbcCallableex2 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ravi","kumar");
		
		//call the procedure
		CallableStatement callableStatement=connection.prepareCall("{Call getAll(?,?,?,?)}");
		
		//set the input data
		callableStatement.setInt(1,1001);
		
		//register one variable to store the data
		callableStatement.registerOutParameter(2,Types.INTEGER);
		callableStatement.registerOutParameter(3,Types.VARCHAR);
		callableStatement.registerOutParameter(4,Types.DOUBLE);
		
		//execute the procedure the output will be stored in register paramter
		callableStatement.executeUpdate();
		
		//print the output
		System.out.println(callableStatement.getInt(2)+" "+callableStatement.getString(3)+" "+callableStatement.getDouble(4));
	}
}
