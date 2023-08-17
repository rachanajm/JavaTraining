package com.nttdatatraining.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdatatraining.connection.Dbconnection;
import com.nttdatatraining.dto.Category;

/**
 * class which contains operations on category
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class CategoryDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDAO.class);
	/**
	 * method which displays all Category Details 
	 * @return
	 */
	public static List<Category> getAllCategories()
	{
		LOGGER.info("Displaying All Category Details");
		List<Category> lstCategories = new ArrayList<>();
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
			
			PreparedStatement pst = 
					con.prepareStatement("select * from category");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Category ctg = new Category();
				ctg.setCategoryid(rs.getInt("categoryid"));
				ctg.setCategoryname(rs.getString("categoryname"));
				lstCategories.add(ctg);
			}
			
		} catch (SQLException e) {

			LOGGER.error("Error,Category Id doesn't exist");
		}
		return lstCategories;
		

	}
}
