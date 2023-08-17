<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@page import="com.nttdatatraining.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int od = Integer.parseInt(request.getParameter("orderid"));
    String add = request.getParameter("address");
	
	OrderDAO odao = new OrderDAO();
	
	Order ord = new Order();
	ord.setOrderid(od);
	ord.setAddress(add);
	
	if(odao.updateOrder(ord))
	{
		out.print("success");
	}
	else
	{
		out.print("failure");	
	}
%>