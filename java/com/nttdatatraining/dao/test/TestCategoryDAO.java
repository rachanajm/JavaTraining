package com.nttdatatraining.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nttdatatraining.dao.CategoryDAO;
/**
 * 
 * @author Rohit
 *
 */
public class TestCategoryDAO {
	/**
	 *  Testing all the categories
	 * 
	 * @test
	 */
	CategoryDAO obj = new CategoryDAO();
	@Test
	public void getAllCategories()// Display all the categories using get()method
	{
		assertEquals(11, obj.getAllCategories().size());
	}
}
