<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@page import="com.nttdatatraining.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    int pid = Integer.parseInt(request.getParameter("orderid"));
	//int oid = Integer.parseInt(request.getParameter("orderId"));
	
		OrderDAO odao = new OrderDAO();
	    Order ord = new Order();
	   
		ord.setOrderid(pid);
	
	if(odao.acceptOrder1(ord))
	{
		out.print("success");
	}
	else
	{
		out.print("failure");	
	}
%>



