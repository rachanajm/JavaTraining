package com.nttdatatraining.dao.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nttdatatraining.dao.AdminDAO;
import com.nttdatatraining.dto.Admin;
/**
 * 
 * @author Rohit
 *
 */
public class TestAdminDAO {
	/**
	 *  Testing the Admin Login Credentials
	 *  
	 *  @test
	 */
	AdminDAO adminDAO = new AdminDAO();
	
	@Test
	public void testValidateUserForLogin_Admin()
	{
		Admin admin = new Admin();
		admin.setAdminid("ABC1");
		admin.setPassword("Pharma@123");
		
		assertTrue(adminDAO.validateAdmin(admin));
	}
}
