package com.nttdatatraining.dao;
import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdatatraining.connection.Dbconnection;
import com.nttdatatraining.dto.Customer;

/**
 * class which contains Customer Operations
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class CustomerDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);
	
    /**
     * Method to add new Customer
     * @param c
     * @return
     */
	 public boolean insertcustomer(Customer c)
		{
			LOGGER.info("Adding new Customer");
			boolean status = false;
			
			try(Connection con = Dbconnection.getdatabaseconnection())
			{
				PreparedStatement pst = 
						con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
						pst.setString(1, c.getCustid());
						pst.setString(2, c.getPassword());
						pst.setString(3, c.getEmailid());
						pst.setInt(4,c.getAge());     // Mark1 for error
						pst.setString(5, c.getContactno());
						pst.setString(6, c.getCity());
						pst.setString(7, c.getState());
						pst.setString(8, c.getPincode());
				
				int count = pst.executeUpdate();
				
				if(count > 0) {
					
					status = true;
				}
			}
			catch (SQLException e) {
				
				LOGGER.error("Error!!,Couldn't Add Customer");	
			}
			
			return status;
		}
	 
	 /**
		 * validateCustomer - method that validates Customer id and password
		 * @return status
		 */
	 public boolean validateCustomer(Customer c) {
		LOGGER.info("Validating customer");
		boolean status= false;
		 
		try(Connection con = Dbconnection.getdatabaseconnection()){
			
				PreparedStatement pst = con.prepareStatement("Select * from Customer where custid = ? and password = ?");
			
				
				pst.setString(1,c.getCustid());
				pst.setString(2,c.getPassword());
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.isBeforeFirst()) {
					status=true;
				}

			}
			catch(SQLException ex) {
				LOGGER.error("ERROR!!,Invalid Customer Credentials");
			}
			
			return status;
			
		}
	 
}



