<%@page import="com.nttdatatraining.dao.AdminDAO"%>
<%@page import="com.nttdatatraining.dto.Admin"%>



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
		

		
		String uid = request.getParameter("adminid");
		String pass = request.getParameter("password");
%>
		<jsp:useBean id="ad" class="com.nttdatatraining.dto.Admin">
			<jsp:setProperty property="adminid" value="<%=uid %>" name="ad"></jsp:setProperty>
			<jsp:setProperty property="password" value="<%=pass %>" name="ad"></jsp:setProperty>
		</jsp:useBean>

<%
		AdminDAO adao = new AdminDAO();
		if(adao.validateAdmin(ad)){
%>
		<% 
			session.setAttribute("USERID", uid);
			session.setMaxInactiveInterval(120);
			response.sendRedirect("admincon111.jsp");
			
		%>
			
		
			<h1 style="color:green" >"Admin Login Success!"</h1>;
		<% 
		}
		else{
%>
		<p style="color:red">Admin ID and Password did'nt match !!!</p>
		<jsp:include page="loginadmin11.jsp"></jsp:include>
		<%
			//response.sendRedirect("loginadmin11.jsp");
		%>
<%			
		}	
%>
</div>	
</body>
</html>