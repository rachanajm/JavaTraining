package com.nttdatatraining.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nttdatatraining.dao.ProductDAO;
/**
 * 
 * @author Rohit
 *
 */
public class TestProductDAO {
	/**
	 * Testing all the products
	 * 
	 * @test
	 */
	ProductDAO ProdDAO = new ProductDAO(); 
	@Test
    public void GetAllProducts()
    {
		/*
	     * Display all the products using get()method
	     */
         assertEquals(3,ProdDAO.getAllProducts().size());
    }
}
