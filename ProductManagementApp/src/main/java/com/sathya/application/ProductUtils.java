package com.sathya.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductUtils {
	public static Connection creatConnection() {
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","ravi","kumar");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
