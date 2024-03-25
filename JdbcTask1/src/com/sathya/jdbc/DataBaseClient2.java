package com.sathya.jdbc;

import java.util.List;

public class DataBaseClient2 {

	public static void main(String[] args) {
		ProductsDao productsDao=new ProductsDao();
		
		/*int result1=productsDao.createProductTable();
			System.out.println("Product table created successfully "+result1);
			
		int result2=productsDao.saveProducts(new Products(1,"SG-Bat",25000.25));
		int result3=productsDao.saveProducts(new Products(2,"BAS-Bat",18500.85));
		int result4=productsDao.saveProducts(new Products(3,"SS-Bat",30151.25));
		int result5=productsDao.saveProducts(new Products(4,"Reebok-Bat",14635.25));
		int result6=productsDao.saveProducts(new Products(5,"MRF-bat",35102.25));
			System.out.println("Product values inserted successfully into products table "+result3);*/
		
		/*Products products=productsDao.getProductById(2);
			System.out.println(products);*/
		
		List<Products> p=productsDao.findAll();
			p.forEach(p1->System.out.println(p1));
		
		/*int count=productsDao.updateByPrice(25000,500);
			System.out.println("Total Updated recoreds "+count);*/
		
		/*int result7=productsDao.deleteById(2);
			System.out.println("Deleted by Id "+result7);*/
		
		/*int result8=productsDao.deleteByPrice(31000.25);
			System.out.println("deleted records are "+result8);*/
		
		/*int result9=productsDao.dropTable();
			System.out.println("Table dropped successfully "+result9);*/
	}

}
