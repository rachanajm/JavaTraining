package com.nttdatatraining.dao;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdatatraining.connection.Dbconnection;
import com.nttdatatraining.dto.Admin;
/**
 * class which contains Admin Operations
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class AdminDAO {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(AdminDAO.class);
	 
	 /**
		 * validateAdmin - method that validates admin id and password
		 * 
		 * @param Admin 
		 * @return boolean
		 */
	
	 public boolean validateAdmin(Admin a)
	 {
			LOGGER.info("Validating Admin");
			boolean status= false;
			
			
			try(Connection con = Dbconnection.getdatabaseconnection()){
			
				PreparedStatement pst = con.prepareStatement("Select * from admin where adminid = ? and password = ?");
			
				pst.setString(1,a.getAdminid() );
				pst.setString(2,a.getPassword() );
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.isBeforeFirst()) {
					System.out.println(status);
					status=true;
					System.out.println(status);
					
				}

			}
			catch(SQLException ex) {
				LOGGER.error("Error!!,Invalid Login Credentials");
				
			}
			return status;
		}
    }
 

