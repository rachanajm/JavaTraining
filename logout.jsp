<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0);
    %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGGINGOUT</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<%
		if(!session.isNew() || session.getAttribute("USERID") != null)
		{
			
			session.setAttribute("USERID", null);
			session.invalidate();
			response.sendRedirect("home11.jsp");
	%>
		<p style=color:green>Logout Successful !!!</p>
		
		

	<%		
		}
		else {
			
	%>
	    
		<p style=color:red> You need to login first !!! </p>
		<% 
			response.sendRedirect("home11.jsp");
		%>
			 
	<%		
		}
	%>
</div>
</body>
</html>