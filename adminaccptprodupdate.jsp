<%@page import="com.nttdatatraining.dao.ProductDAO"%>

<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		int proid = Integer.parseInt(request.getParameter("ProductId"));

		int units = Integer.parseInt(request.getParameter("OrderedUnits"));

		int od = Integer.parseInt(request.getParameter("OrderId"));


	ProductDAO pdao = new ProductDAO();
	OrderDAO odao = new OrderDAO();
	if(pdao.updateQty(proid,units)  && odao.acceptOrder(od))
	{
		response.sendRedirect("admincon111.jsp");
%>
		
		<%--<jsp:forward page="Delete_Success.jsp"></jsp:forward> --%>
<%
	}
	else
	{
		response.sendRedirect("Delete_Failure.jsp");
%>
		<%--<jsp:forward page="Delete_Failure.jsp"></jsp:forward> --%>
<%		
	}
%>
</body>
</html>