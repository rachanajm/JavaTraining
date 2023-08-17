package com.nttdatatraining.dao.test;
import com.nttdatatraining.dto.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import com.nttdatatraining.dao.OrderDAO;
/**
 * 
 * @author Rohit
 *
 */


public class TestOrderDAO {

	/*
	 * Testing the Orders
	 * 
	 * @test
	 */

	OrderDAO orderDAO = new OrderDAO();
	/**
	 *  Testing order when new order is Added
	 *  Setting the productid value using set()method
	 *  Setting the orderedunits value using set()method
	 *  Setting the Address value using set()method
	 *  Setting the Ordereddate value using set()method
	 *  Setting the Requesteddate value using set()method
	 *  Setting the Price value using set()method
	 * 
	 */
	@Test
	public void testAddNewOrder()
	{
		Order order = new Order();
		
		order.setProductid(2);
		order.setOrderedunits(10);
		order.setAddress("Karnataka");
		order.setOrdereddate("2021-10-08");
		order.setRequesteddate("2021-10-18");
		order.setPrice(10);
		assertTrue(orderDAO.addNewOrder(order));
	}
	
	@Test 
	public void testUpdateAddress()
	{
		/*
		 *  Testing after updating the address
		 */
		assertTrue(orderDAO.updateAddress(201, "Karnataka")); 
	}
	
	@Test 
	public void testCancelOrder()
	{
		/*
		 * Testing after cancelling the order
		 */
		assertTrue(orderDAO.cancelOrder(201)); 
	}
	
	@Test
	public void testAllOrderdetails() 
	{
		/*
		 * Testing All Order Details
		 *  Displaying all order details using get()method
		 */
		assertEquals(6,orderDAO.getAllOrderdetails().size());
	}

	@Test 
	public void testPlaceConfirm()
	{
		/*
		 * Testing the place confirmation
		 */
		assertTrue(orderDAO.placeconfirm(202)); 
	}

//	@Test
//	public void testAcceptorder()
//	/*
//	 * Testing the acception of order
//	 * Setting the orderid value using set()method
//	 * Setting the Accepted value using set()method
//	 * Setting the Confirmed value using set()method
//	 */
//	{
//		Order order = new Order();
//		order.setOrderid(3);
//		order.setAccepted(true);
//		order.setConfirmed(true);
//		assertTrue(orderDAO.AcceptorderByAdmin(1,true,true));
//	}
	@Test
	public void testCheckQuantity()//Testing whether the Quantity Present in Product or Not
	{
		
		assertTrue(orderDAO.checkQuantity(2, 1));
	}
	@Test
	public void testPriceFromProduct()// Testing for retrieving the price from product.
	{
		assertEquals(50,orderDAO.getPriceFromProduct(1));
	}
	@Test
	public void testgetProductQuantity()// Testing for retriving the quantity from product.
	{
		assertEquals(3,orderDAO.getProductQty(1));
	}
	
	@Test
	public void testUpdateProductQty() // Testing for updating Product Quantity in product. 
	{
		assertTrue(orderDAO.updateProductQty(1, 15));
	}
	/**
	 * TestOrderdetailsForId-A JUnit TestCase to show the order details for a particular id specified by admin
	 *
	 */
	@Test
	public void testAcceptorder()  
	{
		Order order = new Order();
		order.setOrderid(2);
//		order.setAccepted(true);
		
		assertTrue(orderDAO.acceptOrder(2));
	}
	@Test
	public void testUpdateAmount() // Testing to make amount 0 when order is cancelled by customer.
	{
		assertTrue(orderDAO.updateAmount(1));
	}
	@Test
	public void testupdateCanecl() // Testing to updated cancelled attribute  to true or false.
	{
		assertTrue(orderDAO.updateCancel(1));
	}
	@Test
	public void testupdateAccepted() // Testing to updated accepted attribute to true or false.
	{
		assertTrue(orderDAO.updateAccepted(1));
	}
	@Test 
	public void testDenyOrder()		// Testing to Deny orde for respective order.
	{
		
		assertTrue(orderDAO.denyOrder(3)); 
	}
//	@Test 
//	public void testupdateOrderQty()		// Testing to Deny orde for respective order.
//	{
//		
//		assertTrue(orderDAO.updateOrderQty(1)); 
//	}
}

