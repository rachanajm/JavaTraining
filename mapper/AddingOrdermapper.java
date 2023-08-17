package com.nttdatatraining.mapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import com.nttdatatraining.dto.Order;

/**
 * Mapper called when customer places the order
 *
 */
public interface AddingOrdermapper {
	   
	   static void Addingmapper(Order ord, PreparedStatement pst) throws SQLException {
		  
		pst.setString(1, ord.getCustid());
		pst.setInt(2, ord.getProductid());
		pst.setInt(3, ord.getOrderedunits());
		pst.setString(4, ord.getAddress());
		pst.setDate(5, Date.valueOf(LocalDate.now()));
		pst.setDate(6, Date.valueOf(ord.getRequesteddate()));
		pst.setBoolean(7, false);
		pst.setBoolean(8, false);
		pst.setBoolean(9, true);
		pst.setInt(10, ord.getPrice());
	}
}

