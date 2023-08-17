package com.nttdatatraining.dto;

/**
 * class which contains admin details
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class Admin {
	
	private String adminid;
	private String password;
	
	//Unparameterized Constructor
	public Admin() {
		super();
	}
	
    /**
     * Getters and Setters for Admin Credentials
     * @return
     */
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}