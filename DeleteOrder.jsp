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
	int oid = Integer.parseInt(request.getParameter("orderId"));

	OrderDAO pdao = new OrderDAO();
	
	if(pdao.deleteOrder(oid))
	{
		response.sendRedirect("Delete_Success.jsp");
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