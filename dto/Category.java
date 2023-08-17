package com.nttdatatraining.dto;

/**
 * class which contains Category details
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class Category {
	private int categoryid;
	private String categoryname;
	
	//Unparameterized Constructor
	public Category() {
		super();
	}

	/**
     * Getters and Setters for Admin Credentials
     * @return
     */
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	
	
}
