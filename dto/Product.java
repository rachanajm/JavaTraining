package com.nttdatatraining.dto;


/**
 * class which contains Product details
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class Product {

	private int productid;
	private String productname;
	private int categoryid;
	private int price;
	private int quantity;
	private String description;
	
	//Unparameterized Constructor
	public Product() {
		super();
	}
    
	 /**
     * Getters and Setters for product details
     * @return
     */
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
