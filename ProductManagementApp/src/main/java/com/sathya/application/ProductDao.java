package com.sathya.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	public int save(Product product) throws SQLException {
		
		 	int result=0;
			try( 	Connection connection=ProductUtils.creatConnection();
					 PreparedStatement preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)")){
					
					preparedStatement.setString(1,product.getProId());
					preparedStatement.setString(2,product.getProName());
					preparedStatement.setDouble(3,product.getProPrice());
					preparedStatement.setString(4,product.getProBrand());
					preparedStatement.setString(5,product.getProMadeIn());
					preparedStatement.setDate(6,product.getProMfgDate());
					preparedStatement.setDate(7,product.getProExpDate());
					preparedStatement.setBytes(8,product.getProImage());
					preparedStatement.setBytes(9,product.getProAudio());
					preparedStatement.setBytes(10,product.getProVideo());
					
					
				 	result=preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
	}
	public List<Product> findAll(){
		List<Product> products=new ArrayList<Product>();
		try( Connection connection=ProductUtils.creatConnection();
			 Statement statement=connection.createStatement()
			){
			ResultSet resultSet=statement.executeQuery("select * from product_data");
			while(resultSet.next()) {
				Product product=new Product();
				
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
				product.setProExpDate(resultSet.getDate("proExpDate"));
				product.setProImage(resultSet.getBytes("proImage"));
				product.setProAudio(resultSet.getBytes("proAudio"));
				product.setProVideo(resultSet.getBytes("proVideo"));
				
				products.add(product);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	public int deleteById(String proId) throws Exception{
		int result=0;
		try( 	Connection connection=ProductUtils.creatConnection();
				 PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?")
			){
				preparedStatement.setString(1,proId);
				result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Product findById(String proId) {
		Product product=null;
		try( 	Connection connection=ProductUtils.creatConnection();
				 PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?")
			){
				preparedStatement.setString(1,proId);
				ResultSet resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					product=new Product();
					product.setProId(resultSet.getString(1));
					product.setProName(resultSet.getString(2));
					product.setProPrice(resultSet.getDouble(3));
					product.setProBrand(resultSet.getString(4));
					product.setProMadeIn(resultSet.getString(5));
					product.setProMfgDate(resultSet.getDate(6));
					product.setProExpDate(resultSet.getDate(7));
					product.setProImage(resultSet.getBytes(8));
//					product.setProAudio(resultSet.getBytes(9));
//					product.setProVideo(resultSet.getBytes(10));
				}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	public int updateById(Product product) {
		int result=0;
		String query="update product_data set proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?,proImage=? where proId=?";
		try( 	Connection connection=ProductUtils.creatConnection();
				 PreparedStatement preparedStatement=connection.prepareStatement(query)){
				
				preparedStatement.setString(8,product.getProId());
				preparedStatement.setString(1,product.getProName());
				preparedStatement.setDouble(2,product.getProPrice());
				preparedStatement.setString(3,product.getProBrand());
				preparedStatement.setString(4,product.getProMadeIn());
				preparedStatement.setDate(5,product.getProMfgDate());
				preparedStatement.setDate(6,product.getProExpDate());
				preparedStatement.setBytes(7,product.getProImage());
//				preparedStatement.setBytes(8,product.getProAudio());
//				preparedStatement.setBytes(9,product.getProVideo());
				
			 	result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Product> searchByInput(String input){
		List<Product> products=new ArrayList<Product>();
		String query="select * from product_data where proId like ? or proName like ? or proBrand like ? or proMadeIn like ?";
		try( Connection connection=ProductUtils.creatConnection();
			 PreparedStatement preparedStatement=connection.prepareStatement(query);
			){
			
			preparedStatement.setString(1,"%"+input+"%");
			preparedStatement.setString(2,"%"+input+"%");
			preparedStatement.setString(3,"%"+input+"%");
			preparedStatement.setString(4,"%"+input+"%");		

			ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("ayyindhi roi");
			while(resultSet.next()) {
				Product product=new Product();
				
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
				product.setProExpDate(resultSet.getDate("proExpDate"));
				product.setProImage(resultSet.getBytes("proImage"));
				product.setProAudio(resultSet.getBytes("proAudio"));
				product.setProVideo(resultSet.getBytes("proVideo"));
				
				products.add(product);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
