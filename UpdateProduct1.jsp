<%@page import="com.nttdatatraining.dao.ProductDAO"%>
<%@page import="com.nttdatatraining.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int pid = Integer.parseInt(request.getParameter("productid"));
	int price = Integer.parseInt(request.getParameter("price"));
	int quantity = Integer.parseInt(request.getParameter("quantity"));
	
	ProductDAO pdao = new ProductDAO();
	
	Product prd = new Product();
	prd.setProductid(pid);
	prd.setPrice(price);
	prd.setQuantity(quantity);
	
	if(pdao.updateProduct(prd))
	{
		out.print("success");
	}
	else
	{
		out.print("failure");	
	}
%>