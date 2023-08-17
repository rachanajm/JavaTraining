<%@page import="com.nttdatatraining.dao.CustomerDAO"%>
<%@page import="com.nttdatatraining.dto.Customer"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<%
		String uid = request.getParameter("customerid");
		String pass = request.getParameter("password");
%>
		<jsp:useBean id="cd" class="com.nttdatatraining.dto.Customer">
			<jsp:setProperty property="custid" value="<%=uid %>" name="cd"></jsp:setProperty>
			<jsp:setProperty property="password" value="<%=pass %>" name="cd"></jsp:setProperty>
		</jsp:useBean>

<%
		CustomerDAO cdao = new CustomerDAO();
		if(cdao.validateCustomer(cd)){
	%>
	<% 
			session.setAttribute("USERID", uid);
			session.setMaxInactiveInterval(1200);
			response.sendRedirect("customercon11.jsp");
			%>
			
		<h1>"Customer LoggedIn Success..!"</h1>;
		<% 
		}
		else{
%>
		<p style="color:red">userid or password didn't match !!!</p>
		<jsp:include page="logincustomer11.jsp"></jsp:include>
		<%
			//response.sendRedirect("logincustomer11.jsp");
		%>
<%			
		}	
%>
</div>	
</body>
</html>