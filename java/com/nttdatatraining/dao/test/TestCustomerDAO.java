package com.nttdatatraining.dao.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nttdatatraining.dao.CustomerDAO;
import com.nttdatatraining.dto.Customer;
/**
 * 
 * @author Rohit
 *
 */
public class TestCustomerDAO {
	/**
	 * Testing the customer Login Credentials
	 * 
	 * @test
	 */
		CustomerDAO customerDAO = new CustomerDAO();
	
		@Test
		public void testValidateUserForLogin_Customer()
		/* Validating user for Admin Credentials
		 *  
		 *  Setting the custid values using set()method
		 *  Setting the password values using set()method
		 * 
		 */
		{
			Customer c = new Customer();
			c.setCustid("c01");
			c.setPassword("abcd");
			assertTrue(customerDAO.validateCustomer(c));
		}
		@Test
		public void testAddNewCustomer()// To Register new Customer.
		{
			Customer c = new Customer();
			
			c.setCustid("c04");
			c.setPassword("lmno");
			c.setEmailid("lmn@ntt.com");
			c.setAge(50);
			c.setContactno("1234567890");
			c.setCity("Bangalore");
			c.setState("Karnataka");
			c.setPincode("560073");
			assertTrue(customerDAO.insertcustomer(c));
		}
}
