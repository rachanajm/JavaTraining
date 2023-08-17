package com.nttdatatraining.console;
import com.nttdatatraining.dao.*;

import java.util.List;
import java.util.Scanner;
import com.nttdatatraining.dto.*;
/**
 * AdminconOperation - This class contains admin operations.
 * 
 * @author Rohit
 *
 */
public class AdminconOperation {

	public boolean adm() {
		
		 Scanner sc = new Scanner(System.in);
 
		 boolean z=true;
		 boolean l=false;
		 System.out.println("Welcome Admin....!");
		 while(z) 
			{
				System.out.println("Select the Operation you what to perform");
				System.out.println(" 1. To Show Product_Details    2. To Show Order List  3.To Show Specific detail of Orderid  4. To Accept Order for a Customer ");
		
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:  List<Product> lstProduct = ProductDAO.getAllProducts();		//Displaying all products.
							 System.out.println("All Product are as follows : ");
							 System.out.println("Product Id"+"\t"+"ProductName"+"\t"+"CategoryId"+"\t"+"Prcie"+"\t"+"Quantity"+"\t"+"Description");
							 for(Product pdao : lstProduct)
							 {
								 System.out.println(pdao.getProductid()+"\t\t"+pdao.getProductname()+"\t\t"+pdao.getCategoryid()+"\t\t"+pdao.getPrice()+"\t"+pdao.getQuantity()+"\t\t"+
						 					pdao.getDescription());
							 }
							 System.out.println("");
							 break;
							 
					case 2 : 
							 List<Order> lstOrder = OrderDAO.getAllOrderdetails();		//Displaying all orders.
							 System.out.println("All Orders are as follows : ");
							 System.out.println("OrderId"+"\t"+"CustomerId"+"\t"+"ProductId"+"\t"+"OrderUnits"+"\t"+"Address"+"\t"+"OrderedDate"+"\t"+"RequestedDate"+"\t"+"Accepted"+"\t"+"Cancelled"+"\t"+"Confirmed"+"\t"+"Price");
							 for(Order odao : lstOrder)
							 {
								 System.out.println(odao.getOrderid()+" \t"+odao.getCustid()+"\t\t"+odao.getProductid()+"\t\t"+odao.getOrderedunits()+"\t\t"+odao.getAddress()+"\t"+odao.getOrdereddate()+"\t"+odao.getRequesteddate()+
										 "\t"+odao.isAccepted()+"\t\t"+odao.isCancelled()+"\t\t"+odao.isConfirmed()+"\t\t"+odao.getPrice());

							 }
							 System.out.println("");
				 		 	 break;
				 		 	 
					case 3:	System.out.println("Enter order id for respective Order"); //Displaying particular order details.
							int od=sc.nextInt();
							List<Order> lsto = OrderDAO.getOrderForId(od);
							System.out.println("All Orders are as follows : ");
							System.out.println("OrderId"+"\t"+"CustomerId"+"\t"+"ProductId"+"\t"+"OrderUnits"+"\t"+"Address"+"\t"+"OrderedDate"+"\t"+"RequestedDate"+"\t"+"Accepted"+"\t"+"Cancelled"+"\t"+"Price");
					 		for(Order odao : lsto)
					 		{
					 			System.out.println(odao.getOrderid()+"\t"+odao.getCustid()+"\t"+odao.getProductid()+"\t"+odao.getOrderedunits()+"\t"+odao.getAddress()+"\t"+odao.getOrdereddate()+"    "+odao.getRequesteddate()+
					 					"\t"+odao.isAccepted()+"\t"+odao.isCancelled()+"\t"+odao.isConfirmed());
					 		}
					 		System.out.println("");
					 		break;
		
					case 4:	OrderDAO odao2 = new OrderDAO();			//confirming the order.
							System.out.println("To Accept your order give oderId");
							int l1=sc.nextInt();
							boolean isOrderPlaced = odao2.acceptOrder(l1);

							if(isOrderPlaced)
							{
								System.out.println("Placed Successfully");
							}
							else
							{
								System.out.println(" Couldn't Place Order");
							}
							break;
						

				}
				System.out.println("Wanna Perform More Operation Admin");
				System.out.println("Enter  true for YES and false for NO");
				z=sc.nextBoolean();
				l=true;
			}

		 return l;
		}
}
