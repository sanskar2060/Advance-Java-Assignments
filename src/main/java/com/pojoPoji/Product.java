package com.pojoPoji;

public class Product {
	
	int id ;
	String productName ;
	String description ;
	int cid ;
	double price ;
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Product(int id, String productName, String description, int cid, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.cid = cid;
		this.price = price;
	}

	
	 
	

}