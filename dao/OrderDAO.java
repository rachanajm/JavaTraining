package com.nttdatatraining.dao;

import com.nttdatatraining.connection.Dbconnection;
import com.nttdatatraining.dto.Order;
import com.nttdatatraining.mapper.AddingOrdermapper;
import com.nttdatatraining.mapper.DisplayingOrderDetailsmapper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * class which contains  Operations on Product
 * @author Group-6
 * Since 8-10-2021
 *
 */
public class OrderDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);
	/**
	 * getAllOrder - method to get all order details
	 *  @param list
	 * @return lstCategories
	 */
	public static List<Order> getAllOrderdetails() 
	{
		LOGGER.info("Displaying all the details of order table ");
		List<Order> lstOrderdetails = new ArrayList<>();
		
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where orderedunits>0");
			
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {
			
			LOGGER.error("No order to add into List", e.getMessage());
       }
		return lstOrderdetails;
	}
	
	/**
	 * getAllOrder - method to display all order details for particular customer
	 *  @param list
	 * @return 
	 * @return lstCategories
	 */
	public static List<Order> getAllOrderdetailsforCustomer(String custid) 
	{
		LOGGER.info("Dispaying order details for paticular customer");
		List<Order> lstOrderdetails = new ArrayList<>();
		
	
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where custid=? and orderedunits>0 && accepted = true");
			st.setString(1, custid);
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {
			LOGGER.error("ERROR!!,customer id doesn't exist");

		}
		return lstOrderdetails;
	}
	
	
	public static List<Order> getAllOrderdetailsadmin() 
	{
		LOGGER.info("Displaying all the details of order table ");
		List<Order> lstOrderdetails = new ArrayList<>();
		
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where orderedunits=0");
			
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {
			
			LOGGER.error("No order to add into List", e.getMessage());
       }
		return lstOrderdetails;
	}
	
	

	
	
	/**
	 * getAllOrder - method to display all order details for particular customer
	 *  @param list
	 * @return 
	 * @return lstCategories
	 */
	public static List<Order> getAllCancelledOrderdetailsforCustomer(String custid) 
	{
		LOGGER.info("Dispaying order details for paticular customer");
		List<Order> lstOrderdetails = new ArrayList<>();
		
	
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where custid=? and orderedunits=0");
			st.setString(1, custid);
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {
			LOGGER.error("ERROR!!,customer id doesn't exist");

		}
		return lstOrderdetails;
	}
	
	
	
	/**
	 * getAllOrder - method to display all order details for provided order id
	 *  @param list
	 * @return 
	 * @return lstCategories
	 */
	public static List<Order> getAllOrderdetails(int id) 
	{
		LOGGER.info("Dispaying order details for given order id");
		List<Order> lstOrderdetails = new ArrayList<>();
		
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where orderid = id");
			
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {

			LOGGER.error("Error!!,Given Order-Id  doesn't exist",e.getMessage());	
		}
		return lstOrderdetails;
	}

	
	
	public static List<Order> getOrderForId(int odid) 
	{
		List<Order> lstOrder = new ArrayList<>();
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
			
			PreparedStatement pst = 
					con.prepareStatement("select * from order1 where orderid = " + odid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Order o1 = new Order();
				
				o1.setOrderid(rs.getInt("orderid"));
				o1.setCustid(rs.getString("custid"));
				o1.setProductid(rs.getInt("productid"));
				o1.setOrderedunits(rs.getInt("orderedunits"));
				o1.setAddress(rs.getString("deliveryaddress"));
				o1.setOrdereddate(rs.getString("ordereddate"));
				o1.setRequesteddate( rs.getString("requesteddate"));
				o1.setAccepted(rs.getBoolean("accepted"));
				o1.setCancelled(rs.getBoolean("cancelled"));
				o1.setConfirmed(rs.getBoolean("confirmed"));
				lstOrder.add(o1);
			}
			
		} catch (SQLException e) {
			LOGGER.error("No order to add into list",e.getMessage());

		}
		return lstOrder;
	}
	/**
	 * Method to place order by customer
	 * @return
	 */
	public boolean addNewOrder(Order ord)
	
	{
		LOGGER.info("Customer placing order");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("insert into order1 (custid,productid,orderedunits,deliveryaddress,"
							+ "ordereddate,requesteddate,accepted,cancelled,confirmed,amount) values(?,?,?,?,?,?,?,?,?,?)");

//			pst.setString(1, ord.getCustid());
//			pst.setInt(2, ord.getProductid());
//			pst.setInt(3, ord.getOrderedunits());
//			pst.setString(4, ord.getAddress());
//			pst.setDate(5, Date.valueOf(LocalDate.now()));
//			pst.setDate(6, Date.valueOf(ord.getRequesteddate()));
//			pst.setBoolean(7, false);
//			pst.setBoolean(8, false);
//			pst.setBoolean(9, true);
//			pst.setInt(10, ord.getPrice());
			AddingOrdermapper.Addingmapper(ord, pst);//Mapper Interface

			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("Order not placed by Customer",e.getMessage());

		}
		
		return b;
	}
	/**
	 * Method to update accepted in order table by admin
	 * @return
	 */
	public boolean acceptOrder1(Order od)
	{
		LOGGER.info("Admin accepting order");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set accepted = true where orderid = ?" );
			pst.setInt(1, od.getOrderid());
			

			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order Id doesn't exist");

		}
		return b;
	}

    /**
     * Method to update cancelled in order table when customer cancels the order
     * @return
     */
   public boolean CancelledorderForCustomer(Order o)

	{
	   LOGGER.info("Updating cancelled when customer deletes the order");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set cancelled=? where orderid=?" );
						
			pst.setBoolean(1, o.isCancelled());
			pst.setInt(2, o.getOrderid());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		return b;
	}
	/**
	 * Method to update confirmed in order table when customer denies order
	 * @return
	 */
	public boolean denyOrder(int od)
	{
		LOGGER.info("Updating confirmed when customer cancelles order");
		boolean b = false;
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set confirmed = false where orderid = "+ od );			
			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order doesn't exist");

		}
		return b;
	}
	
	/**
	 * Method to update amount in order table when customer denies order
	 * @return
	 */
	public boolean updateAmount(int od) 
	{
		LOGGER.info("Updating amount when customer cancelles order");
		boolean b = false;
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set amount = 0 where orderid = "+ od );			
			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		return b;
	}
	/**
	 * Method to update cancelled in order table when customer denies order
	 * @return
	 */
	public boolean updateCancel(int od)
	{
		LOGGER.info("Updating cancelled when customer cancelles order");
		boolean b = false;
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set cancelled = 1 where orderid = "+ od );			
			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		return b;
	}
	/**
	 * Method to update accepted in order table when customer cancelles order
	 * @return
	 */
	public boolean updateAccepted(int od)
	{
		LOGGER.info("Updating accepted when customer cancelles order");
		boolean b = false;
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set accepted = 0 where orderid = "+ od );			
			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		return b;
	}
	/**
	 * Method to update confirmed when customer places order
	 * @return
	 */
	public boolean placeconfirm(int orderid)
	{
		LOGGER.info("Updating confirmed when customer places order");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set confirmed = true where orderid = ?");
			
			pst.setInt(1,orderid);
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		
		return b;
	}

	/**
	 * method to update product  quantity in product table
	 */
	public boolean updateProductQty(int pid, int updatedProdQty) 
	{
		LOGGER.info("Updating  product quantity");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update product set quantity = "+ updatedProdQty+ " where productid ="+ pid);
			
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,product id doesn't exist");

		}
		
		return b;
	}
	/**
	 * method to update ordered units in order table when customer cancelles order
	 */
	public boolean updateOrderQty(int oid)
	{
		LOGGER.info("Updating  ordered units to 0");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set orderedunits = 0   where orderid ="+ oid);
			

			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		
		return b;
	}
	
	/**
	 * method to get product quantity from product table
	 * @return
	 */
	public int getProductQty(int pid) 
	{
		LOGGER.info("Getting product quantity from product table");
		int qty= 0;
		
		try (Connection con = Dbconnection.getdatabaseconnection())
		{
		
			PreparedStatement pst = 
					con.prepareStatement("select quantity from product where productid = "+ pid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				qty=rs.getInt("quantity");
			}

		} catch (SQLException e) {
			LOGGER.error("ERROR!!,product id doesn't exist");

		}
		
		return qty;
	}

	/**
	 * method to get ordered units from order table
	 * @return
	 */
	public int getQantityFromOrdered(int oid)
	{
		LOGGER.info("Getting ordered units from order table");
		int qty= 0;
		
		try (Connection con = Dbconnection.getdatabaseconnection())
		{
		
			PreparedStatement pst = 
					con.prepareStatement("select orderedunits from order1 where orderid = "+ oid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				qty=rs.getInt("orderedunits");
			}

		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		
		return qty;
	}
	
	/**
	 * method to get product id  from order table for particular order id
	 * @return
	 */
	public int getProductId(int oid)
	{
		LOGGER.info("Getting product id  from order table for particular id");
		int orderpid=0;
		try (Connection con = Dbconnection.getdatabaseconnection())
		{
		
			PreparedStatement pst = 
					con.prepareStatement("select productid from order1 where orderid = "+ oid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				orderpid=rs.getInt("productid");
			}

		} catch (SQLException e) {
			LOGGER.error("ERROR!!,order id doesn't exist");

		}
		return orderpid;
	}
	
	/**
	 * method to get price  of product from product table 
	 * @return
	 */
	public int getPriceFromProduct(int pid)// Returns the price of specific product id.
	{
		LOGGER.info("Getting price  of product from product table ");
		int price = 0;
		
		try (Connection con = Dbconnection.getdatabaseconnection())
		{
		
			PreparedStatement pst = 
					con.prepareStatement("select price from product where productid = "+ pid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				price=rs.getInt("price");
			}

		} catch (SQLException e) {
			LOGGER.error("ERROR!!,product id doesn't exist");

		}
		return price;
	}
	
	/**
	 * method to get product quantity from product table
	 * @return
	 */
	public boolean checkQuantity(int ordquant,int pdid)  //checking quantity of the product.

	{
		LOGGER.info("Getting product quantity from product table");
		int prodquant=0;
		try (Connection con = Dbconnection.getdatabaseconnection())
		{
			
		
			PreparedStatement pst = 
					con.prepareStatement("select quantity from product where productid = "+ pdid);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				prodquant=rs.getInt("quantity");
			}
			//check
			if(ordquant<=prodquant && ordquant>0){
				return true;
			}
			else {
				return false;
			}
		}
		catch (SQLException e) {
			LOGGER.error("ERROR!!,product id doesn't exist");

		}
		return false;
	}
	/**
	 * method to update delivery address in order table
	 * @return
	 */
	public boolean updateOrder(Order oid)
	{
		LOGGER.info("Updating delivery address");
		boolean b = false;
		
		try(Connection con = Dbconnection.getdatabaseconnection()){
		
		PreparedStatement pst = con.prepareStatement("update order1 set deliveryaddress = ? where orderid=?");
				
		
		
		pst.setString(1, oid.getAddress());
		pst.setInt(2, oid.getOrderid());
		
		int count = pst.executeUpdate();
		
		if(count > 0)
			b = true;
	}
	catch(SQLException ex)
	{
		LOGGER.error("ERROR!!,order id doesn't exist");
	}
	
		return b;

	}
	/**
	 *   method for admin to accept the order
	 * @return boolean-Status of Accepted
	 */
	public boolean acceptOrder(int od)
	{
		LOGGER.info("Admin Accepting the order");
		boolean b = false;
		
		try (Connection con = Dbconnection.getdatabaseconnection()){
		
			PreparedStatement pst = 
					con.prepareStatement("update order1 set accepted =true where orderid = ?" );
            pst.setInt(1, od);
			int count = pst.executeUpdate();
			if(count > 0)
				b = true;
			
		} catch (SQLException e) {
			LOGGER.error(" Error!!,Not Accepted by Admin ");
		}
		return b;
	}
	
	public boolean deleteOrder(int pid)
	{
		boolean b = false;
		
			try(Connection con = Dbconnection.getdatabaseconnection()){
			
			PreparedStatement pst = con.prepareStatement("delete from order1 where "
					+ "orderid = ?");
			
			pst.setInt(1, pid);
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				b = true;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
			return b;
	}
	
	public static List<Order> getAllOrderdetailsforCustomerUnderReview(String custid) 
	{
		LOGGER.info("Dispaying order details for paticular customer");
		List<Order> lstOrderdetails = new ArrayList<>();
		
	
		try(Connection con = Dbconnection.getdatabaseconnection())
		{
			PreparedStatement st = con.prepareStatement("select * from order1 where custid=? and orderedunits>0 && accepted = false");
			st.setString(1, custid);
			ResultSet rs = st.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()){
				
					Order ord=new Order();
					DisplayingOrderDetailsmapper.MapperDetails(rs, ord);//Mapper Interface
					lstOrderdetails.add(ord);
				}

			}
			
			con.close();
		}
		catch (SQLException e) {
			LOGGER.error("ERROR!!,customer id doesn't exist");

		}
		return lstOrderdetails;
	}
}


