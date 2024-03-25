package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batchexe {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ravi","kumar");
		Statement statement=connection.createStatement();
		
		statement.addBatch("create table players(pname varchar2(20),psal number(10,2),page number)");
		statement.addBatch("insert into players values('cknaidu',25153.25,1)");
		statement.addBatch("insert into players values('madhu',53546.35,2)");
		statement.addBatch("delete from players where page=1");
		statement.addBatch("drop table players");
		
		int [] results=statement.executeBatch();
			
		for (int i : results) {
			System.out.println(i);
		}
			connection.close();
	}

}
