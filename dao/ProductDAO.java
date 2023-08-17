package com.nttdatatraining.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdatatraining.connection.Dbconnection;
import com.nttdatatraining.dto.Product;

/**
 * class which contains  Operations on Product
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class ProductDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);
	/**
	 * Method to display  all products to Admin even when quantity null
	 * @return
	 */
	public static List<Product> getAllProducts()  
	{
		LOGGER.info("Displaying All Products");
		List<Product> lstProducts = new ArrayList<>(); 
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
			
			PreparedStatement pst = 
					con.prepareStatement("select * from product");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product prod = new Product();
				prod.setProductid(rs.getInt("productid"));
				prod.setProductname(rs.getString("productname"));
                prod.setCategoryid(rs.getInt("categoryid"));
                prod.setPrice(rs.getInt("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
				lstProducts.add(prod);
			}
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,No products to display");

		}
		
		return lstProducts;
	}
	
	/**
	 * Method to display  all products to Customer even when quantity available
	 * @return
	 */
	public static List<Product> getAllProductsForCustomer()  
	{
		LOGGER.info("Displaying all products to Customer ");
		List<Product> lstProducts = new ArrayList<>();
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
			
			PreparedStatement pst = 
					con.prepareStatement("select * from product where quantity > "+ 0);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product prod = new Product();
				prod.setProductid(rs.getInt("productid"));
				prod.setProductname(rs.getString("productname"));
                prod.setCategoryid(rs.getInt("categoryid"));
                prod.setPrice(rs.getInt("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
				lstProducts.add(prod);
			}
			
		} catch (SQLException e) {
			LOGGER.error("No products to display");
		}
		
		return lstProducts;
	}

	/**
	 * Method to update product price and quantity by admin
	 * @return
	 */
	public boolean updateProduct(Product p)
	{
		LOGGER.info("Updating Product Price and quantity");
		boolean status = false;
		
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement pst = 
					con.prepareStatement("update product set price = ? , quantity = ? " + "where productid = ?");
			
			pst.setInt(1, p.getPrice());
			pst.setInt(2, p.getQuantity());
			pst.setInt(3, p.getProductid());
			
			int count = pst.executeUpdate();
			
			if(count > 0) {
				status = true;
			}
		}
		catch (SQLException e) {
			
			LOGGER.error("ERROR!!,Product Id doesn't exist");
		}
		
		return status;
	}
	/**
	 * Method to set Quantity  to 0 when product deleted
	 * @return
	 */
	
	public boolean deleteProduct(int pid)
	{
		LOGGER.info(" Setting quantity to 0 when  Product deleted");
		boolean status = false;
		
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement pst = 
					con.prepareStatement("update product set quantity = 0 where productid = ?");
			
			pst.setInt(1, pid);
			
			int count = pst.executeUpdate();
			
			if(count > 0) {
				
				status = true;
			}
		}
		catch (SQLException e) {
			
			LOGGER.error("ERROR!!.Product Id doesn't exist");
		}
		
		return status;
	}
	
	
	
	public boolean updateQty(int pid,int unit) {
		LOGGER.info(" Setting quantity to 0 when  Product deleted");
		boolean status = false;
		OrderDAO o = new OrderDAO();
		 int qty =o.getProductQty(pid);
		 int z = qty-unit;
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			
			PreparedStatement pst = 
					con.prepareStatement("update product set quantity = ? where productid = ?");
			
					
			pst.setInt(1, z);
			pst.setInt(2, pid);
			
			int count = pst.executeUpdate();
			
			if(count > 0) {
				
				status = true;
			}
		}
		catch (SQLException e) {
			
			LOGGER.error("ERROR!!.Product Id doesn't exist");
		}
		return status;
	}

}
