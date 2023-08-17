package com.nttdatatraining.main;
import com.nttdatatraining.console.*;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdatatraining.dao.AdminDAO;
//import com.nttdatatraining.dao.CategoryDAO;
import com.nttdatatraining.dao.CustomerDAO;
//import com.nttdatatraining.dao.OrderDAO;
//import com.nttdatatraining.dao.ProductDAO;
import com.nttdatatraining.dto.Admin;
import com.nttdatatraining.dto.Customer;
//import com.nttdatatraining.dto.Product;
import com.nttdatatraining.exception.PasswordException;
/**
 * AppMain - This class contains all the operatins of admin and coustomer.
 * 
 * @author admin
 */
public class AppMain{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(AppMain.class);
	
	
//	public static String customerId="";
	/**
	   * Main method that contains console API.
	   * 
	   * @param args
	   */
	public static void main(String []args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println(" Welcome To Pharmacy_Unit ");

		boolean w=true;
		
		while(w)
		{
		System.out.println("\n Enter your choice for Login ");
		System.out.println("\n 1. Admin \t 2. Customer");
		System.out.println("\n 3. To Register New Customer");
		int x= sc.nextInt();
		switch(x)
		{
		/**
 		* AdminDAO-Java Code  for Validating Admin Login Credentials 
 		* @author-Rohit
 		*/
		case 1 : 	
					AdminDAO adao = new AdminDAO();
					Admin a1 = new Admin();
					System.out.println("Enter LogIn Credentils");
					System.out.println("Enter Admin Id");
					a1.setAdminid(sc.next());
					System.out.println("Enter Password :");
					String s1= sc.next();
					a1.setPassword(s1);
					 boolean b1=false;
					try {
						int l=s1.length();
						if(l > 15) 
							throw new PasswordException("Password exceeds limit !!!");
						 else
							  b1 = adao.validateAdmin(a1);
//							    System.out.println("Login Successful !!!");
					}
					catch(PasswordException exc) {
						System.out.println(exc.getMessage());
					}
//					boolean b1 = adao.validateAdmin(a1);
					boolean a;
					if(b1)
					{
//						System.out.println("Admin LogIn Success");
						LOGGER.info("Admin LogIn Success");
						AdminconOperation ad = new AdminconOperation();
						a=ad.adm();
						if(a) 
							System.out.println("Logged Out Success");
//						LOGGER.info("Logged Out Success by Admin ");
					}
					else 
					{
//						System.out.println("Admin LogIn Failed");
						LOGGER.error("Admin LogIn Failed..!");
					}
					break;
					
					
					/**
			 		* CustomerDAO-Java Code for Validating Customer Login Credentials 
			 		* @author-Rohit
			 		*/
				
		case 2 :	
					CustomerDAO cdao = new CustomerDAO();
					Customer c1 = new Customer();
					System.out.println("Enter LogIn Credentils");
					System.out.println("Enter Customer Id:");
					
					c1.setCustid(sc.next());
//					AppMain.customerId =sc.next();
//					c1.setCustid(AppMain.customerId);		
					System.out.println("Enter Password :");
				
					String s2= sc.next();
					c1.setPassword(s2);
					boolean b2=false;
					try {
						int l=s2.length();
						if(l > 15) 
							throw new PasswordException("Password exceeds limit !!!");
						 else {
								b2 = cdao.validateCustomer(c1);
//							    System.out.println("Login Successful !!!");
						 }
					}
					catch(PasswordException exc) {
						System.out.println(exc.getMessage());
					}
//					boolean b2 = cdao.validateCustomer(c1);
					if(b2) {
//						System.out.println("Customer LogIn Success");
						LOGGER.info("Customer LogIn Success");
						CustomerconOperation cd = new CustomerconOperation();
						cd.cust();
					}
					else {
//						System.out.println("Customer LogIn Failed");
						LOGGER.error("Customer LogIn Failed.!");
					}
					break;
					
					/**
				        * CustomerDAO-Java Code for New User to Register
				        * @author-Rohit
				        */
		case 3 :	
					CustomerDAO cdao1 = new CustomerDAO();
					System.out.println("Hi... New User Welcome TO Pharmacy_Unit");
					Customer c= new Customer();
					System.out.println("Enter customerid:");
					c.setCustid(sc.next());
					System.out.println("Enter customerpassword:");
					c.setPassword(sc.next());
					System.out.println("Enter emailid:");
					c.setEmailid(sc.next());
					System.out.println("Enter Age:");
					c.setAge(sc.nextInt());
					System.out.println("Enetr Contactno: ");
					c.setContactno(sc.next());
					System.out.println("Enter City");
					c.setCity(sc.next());
					System.out.println("Enter State");
					c.setState(sc.next());
					System.out.println("Enter pincode");
					c.setPincode(sc.next());
					boolean b = cdao1.insertcustomer(c);
					if(b)
						System.out.println("Customer added successfully");
					else
						System.out.println("Customer addition failed");
					break;
		default :   System.out.println("Enter Proper Choice You want to Perform");
					return;
					
		}
		System.out.println("Wanna Perform More Operation: MainApp");		
		System.out.println("Enter  true for YES and false for NO");
		w=sc.nextBoolean();
		}
		System.out.println("Thanks For Visiting");
		System.exit(0);
	}
}


