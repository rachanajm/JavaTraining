package com.nttdatatraining.console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.nttdatatraining.connection.DbPooledConnection;
import com.nttdatatraining.dao.CategoryDAO;
import com.nttdatatraining.dao.OrderDAO;
import com.nttdatatraining.dao.ProductDAO;
import com.nttdatatraining.dto.Category;
import com.nttdatatraining.dto.Order;
import com.nttdatatraining.dto.Product;
import com.nttdatatraining.main.AppMain;
/**
 * CustomerconOperation - This class contains customer operation.
 * 
 * @author Rohit
 *
 */
public class CustomerconOperation {

public void cust() {
		
		Scanner sc = new Scanner(System.in);
		OrderDAO odao = new OrderDAO();
		int price;
		int availableQty=0;
		int pid=0;
		int qty=0;
		
		int id;
		boolean z=true;
		
		System.out.println("Welcome Customer....!");
		while(z) 
		{
			System.out.println("Select the Operation you what to perform");
			
			System.out.println(" 1. To Show Category_Details  2. To Show all Products  3. To Place_Order  4. To Update Placed_Order 5. To Show order placed by Customer");
			System.out.println(" 6. To cancel the order after placing the product.");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1: 
					List<Category> lstCategories = CategoryDAO.getAllCategories(); //Listing all categories.
					System.out.println("All Categories are as follows : ");
					System.out.println("CategoryId"+"\t"+"Categoryname");
					for(Category cdao : lstCategories) {
						System.out.println(cdao.getCategoryid()+"\t\t"+cdao.getCategoryname());

					}				
					System.out.println("");
					break; 
					
			case 2:	List<Product> lstProduct = ProductDAO.getAllProductsForCustomer(); //Displaying all products for customer.
			 		System.out.println("All Product are as follows : ");
			 		System.out.println("Product Id"+"\t"+"ProductName"+"\t"+"CategoryId"+"\t"+"Prcie"+"\t"+"Quantity"+"\t"+"Description");
			 		for(Product pdao : lstProduct) {
			 			System.out.println(pdao.getProductid()+"\t\t"+pdao.getProductname()+"\t\t"+pdao.getCategoryid()+"\t\t"+pdao.getPrice()+"\t"+pdao.getQuantity()+"\t\t"+
			 					pdao.getDescription());

			 		}
			 		System.out.println("");
			 		break; 
			 		
			case 3: 
					OrderDAO odao1 = new OrderDAO(); 	//creating object of orderDAO class.
					Order od1 = new Order();			//Placing order by customer.
					System.out.println("Enter your Customer id : ");
					od1.setCustid(sc.next());
//					System.out.println(AppMain.customerId);
					
					System.out.println("Enter Product id : ");
					pid=sc.nextInt();
					od1.setProductid(pid);
					
					System.out.println("Enter the Quantities of Units");
					qty=sc.nextInt();
//					od1.setOrderedunits(qty);
					
					boolean b4 = odao1.checkQuantity(qty,pid);  //Checking for quantity available
					if(b4) {
						od1.setOrderedunits(qty);
						price=odao1.getPriceFromProduct(pid);  //Getting  price from product table.
						
						od1.setPrice(price * qty);	//Inserting Amount for each Order
					}
					else {
						System.out.println("Invalid Quantity");
						break;
					}
					System.out.println("Enter the Address ");
					od1.setAddress(sc.next());
//					System.out.println("Enter order data in format: 'YYYY-MM-DD' ");
//					od1.setOrdereddate();
					System.out.println("Enter request data in format: 'YYYY-MM-DD' ");
					od1.setRequesteddate(sc.next());
					availableQty=odao1.getProductQty(pid);
					boolean isQtyUpdated = odao1.updateProductQty(pid, availableQty-qty); //Updating Quantity to product table
					if(isQtyUpdated)
					{
						odao.addNewOrder(od1);
						System.out.println(" Order Placed Successfully");
					}
					else 
					{
						System.out.println("Order placing failed");
					}
					
					break;
				 
			case 4: 
					System.out.println("Enter Orderid and Address to Update : ");   //updating delivery address.
			
					id=sc.nextInt();
					String st=sc.next();
					Order oid =new Order();
					boolean b1 = odao.updateOrder(oid);
	
					if(b1)
						System.out.println("Order Updated successfully");
					else
						System.out.println("No such order found or Updation failed");
					break; 
			case 5: 
					System.out.println("Enter Custid");
					int cid =sc.nextInt();
					List<Order> lstOrder = OrderDAO.getAllOrderdetails(cid);		//Displaying all orders.
					System.out.println("All Orders are as follows : ");
					System.out.println("OrderId"+"\t"+"CustomerId"+"\t"+"ProductId"+"\t"+"OrderUnits"+"\t"+"Address"+"\t"+"OrderedDate"+"\t"+"RequestedDate"+"\t"+"Accepted"+"\t"+"Cancelled"+"\t"+"Confirmed"+"\t"+"Price");
					for(Order odao11 : lstOrder)
					{
						System.out.println(odao11.getOrderid()+" \t"+odao11.getCustid()+"\t\t"+odao11.getProductid()+"\t\t"+odao11.getOrderedunits()+"\t\t"+odao11.getAddress()+"\t"+odao11.getOrdereddate()+"\t"+odao11.getRequesteddate()+
								"\t"+odao11.isAccepted()+"\t\t"+odao11.isCancelled()+"\t\t"+odao11.isConfirmed()+"\t\t"+odao11.getPrice());

					}
					System.out.println("");
					break;
			case 6:
					try(Connection con = DbPooledConnection.getdatabaseconnection()){
						con.setAutoCommit(false);
						OrderDAO odao4 = new OrderDAO();
					System.out.println("To Cancel your order give oderId");
					int cancid= sc.nextInt();
					int qtycanci = odao4.getQantityFromOrdered(cancid);
					int orderpid = odao4.getProductId(cancid);
					
					int orderAvailableQty=odao4.getProductQty(orderpid);
					System.out.println("CancelledOrderid"+"\t"+"OrderedQantity"+"\t"+"OrderProductId"+"\t"+"ProductAvailableQty"+"\t"+"OrderedQantity+ProductAvailableQty");
					
					System.out.println(cancid+"\t"+qtycanci+"\t"+orderpid+"\t"+orderAvailableQty+"\t"+(orderAvailableQty+qtycanci));
					
					boolean isQtyUpdatedToProduct = odao4.updateProductQty(orderpid, orderAvailableQty+qtycanci);
					boolean upDatePriceOrder = odao4.updateAmount(cancid);   
					boolean upDateCancelDataOrder = odao4.updateCancel(cancid);
					boolean upDateAcceptedOrder = odao4.updateAccepted(cancid);
					boolean upDateOrderQtyOrder = odao4.updateOrderQty(cancid);
					boolean isOrderDenyedForProduct = odao4.denyOrder(cancid);
					if(isQtyUpdatedToProduct && upDatePriceOrder && upDateCancelDataOrder && upDateAcceptedOrder && upDateOrderQtyOrder && isOrderDenyedForProduct)
					{
						System.out.println(" Order Unplaced Successfully and Quantity Updated Back to Product");
						con.commit();
					}
					else 
					{
						System.out.println("Order cancellation failed");
						con.rollback();
					}
					}
					catch(SQLException ex) {
						ex.printStackTrace(); //SQL printstack trace example
					}
					break;

		}
		System.out.println("Wanna Perform More Operation: Customer ");
		System.out.println("Enter  true for YES and false for NO");
		z=sc.nextBoolean();
	   }

	}
	
}
