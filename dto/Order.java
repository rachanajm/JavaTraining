package com.nttdatatraining.dto;
/**
 * class which contains Order details
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class Order {
	/*
	 *  These are the variables declared for the class order
	 */
   private int orderid;
   private String custid;
   private int productid;
   private int orderedunits;
   private String address;
   private String ordereddate;
   private String requesteddate;
   private boolean accepted;
   private boolean cancelled;
   private boolean confirmed;
   private int price;

 //Unparameterized Constructor
   public Order() {
	super();
   }
   
   /**
    * Getters and Setters for order details
    * @return
    */

   public int getOrderid() {
	  return orderid;
   }

   public void setOrderid(int orderid) {
	  this.orderid = orderid;
   }

   public String getCustid() {
	  return custid;
   }

   public void setCustid(String custid) {
	  this.custid = custid;
   }

   public int getProductid() {
	  return productid;
   }

   public void setProductid(int productid) {
	  this.productid = productid;
   }

   public int getOrderedunits() {
	  return orderedunits;
   }

   public void setOrderedunits(int orderedunits) {
	 this.orderedunits = orderedunits;
   }

   public String getAddress() {
	  return address;
   }

   public void setAddress(String address) {
	  this.address = address;
   }

   public String getOrdereddate() {
	   return ordereddate;
   }

   public void setOrdereddate(String ordereddate) {
	   this.ordereddate = ordereddate;
   }

   public String getRequesteddate() {
	   return requesteddate;
   }

   public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
	}

   public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
