package com.sathya.jdbc;

public class Products {
	int proId;
	String proName;
	double proPrice;
	public Products(int proId, String proName, double proPrice) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	@Override
	public String toString() {
		return "Products [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
	}
	
}