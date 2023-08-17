package com.nttdatatraining.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;




import com.nttdatatraining.dto.Order;

public interface DisplayingOrderDetailsmapper {
	 
	  static void MapperDetails(ResultSet rs, Order ord) throws SQLException {
		
		ord.setOrderid( rs.getInt("orderid"));
		ord.setCustid( rs.getString("custid"));
		ord.setProductid( rs.getInt("productid"));
		ord.setOrderedunits( rs.getInt("orderedunits"));
		ord.setAddress( rs.getString("deliveryaddress"));
		ord.setOrdereddate( rs.getString("ordereddate"));
		ord.setRequesteddate( rs.getString("requesteddate"));
		ord.setAccepted(rs.getBoolean("accepted"));
		ord.setCancelled(rs.getBoolean("cancelled"));
		ord.setConfirmed(rs.getBoolean("confirmed"));
		ord.setPrice(rs.getInt("amount"));
	}
}