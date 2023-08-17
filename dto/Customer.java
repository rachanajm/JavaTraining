package com.nttdatatraining.dto;

/**
 * class which contains Customer details
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class Customer {
	public  String custid;
	private String password;
	private String emailid;
	private int age;
	private String contactno;
	private String city;
	private String state;
	private String pincode;
	
	//Unparameterized Constructor
	public Customer() {
		super();
	}
   /**
    * Getters and Setters for customer details
    * @return
    */
	public  String getCustid() {
		return custid;
	}

	public  void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
