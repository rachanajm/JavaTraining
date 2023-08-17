<%@page import="com.nttdatatraining.dao.CustomerDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		String cid = request.getParameter("uname");
		String pass = request.getParameter("password");
		String email=request.getParameter("email");
		
		int age1=Integer.parseInt(request.getParameter("age"));
		
		String pno=request.getParameter("telnum");;
		String city1=request.getParameter("city");;
		String state1=request.getParameter("state");;
		String pincode1=request.getParameter("pincode");;
		
	%>	
	
	<jsp:useBean id="cust" class="com.nttdatatraining.dto.Customer">
		<jsp:setProperty property="custid" value="<%=cid %>" name="cust"></jsp:setProperty>
		<jsp:setProperty property="password" value="<%=pass %>" name="cust"></jsp:setProperty>
		<jsp:setProperty property="emailid" value="<%=email %>" name="cust"></jsp:setProperty>
		
		<jsp:setProperty property="age" value="<%=age1 %>" name="cust"></jsp:setProperty>
		
		<jsp:setProperty property="contactno" value="<%=pno %>" name="cust"></jsp:setProperty>
		<jsp:setProperty property="city" value="<%=city1 %>" name="cust"></jsp:setProperty>
		<jsp:setProperty property="state" value="<%=state1 %>" name="cust"></jsp:setProperty>
		<jsp:setProperty property="pincode" value="<%=pincode1 %>" name="cust"></jsp:setProperty>
	</jsp:useBean>
	
	<%
		CustomerDAO custDao = new CustomerDAO();
		if(custDao.insertcustomer(cust)) {
	%>
		<p style="color:green">Registration Successful !!! </p>
		<jsp:include page="home11.jsp"></jsp:include>
	<%		
		}
		else {
	%>
		<p style="color:red">Registration Failed !!! </p>
		<jsp:include page="home11.jsp"></jsp:include>
	<%		
		}
	%>
</div>
</body>
</html>