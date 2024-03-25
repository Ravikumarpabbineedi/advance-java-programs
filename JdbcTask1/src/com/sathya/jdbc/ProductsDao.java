package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductsDao {
	public int createProductTable() {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement()
			){
				 result=statement.executeUpdate("create table products(proId number,proName varchar2(25),proPrice number(30,2))");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int saveProducts(Products prod) {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into products values(?,?,?)")){
			preparedStatement.setInt(1,prod.getProId());
			preparedStatement.setString(2,prod.getProName());
			preparedStatement.setDouble(3,prod.getProPrice());
			result=preparedStatement.executeUpdate();	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Products getProductById(int Id) {
		Products products=new Products();;
		try( Connection connection=DbConnection.createConnection();
			 PreparedStatement preparedStatement=connection.prepareStatement("select * from products where proId=?")
		   ){
			preparedStatement.setInt(1,Id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				products.setProId(resultSet.getInt(1));
				products.setProName(resultSet.getString(2));
				products.setProPrice(resultSet.getDouble(3));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Products> findAll(){
		List<Products> prodcts=new ArrayList<>();
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement()
			){
			ResultSet resultSet=statement.executeQuery("select * from products");
			
			while(resultSet.next()){
				Products products=new Products();
				products.setProId(resultSet.getInt(1));
				products.setProName(resultSet.getString(2));
				products.setProPrice(resultSet.getDouble(3));
				prodcts.add(products);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return prodcts;
	}
	
	public int updateByPrice(double priceRange,double incrementValue) {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update Products set proPrice=proPrice+? where proPrice>?")){
			preparedStatement.setDouble(1,incrementValue);
			preparedStatement.setDouble(2,priceRange);
			result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteById(int id) {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from products where proId===?")){
			preparedStatement.setInt(1,id);
			result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteByPrice(double price) {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from products where proPrice>?")){
			preparedStatement.setDouble(1,price);
			result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int dropTable() {
		int result=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("drop table products")){
				result=preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
	}
}
