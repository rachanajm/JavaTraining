<%@page import="com.nttdatatraining.dto.Order"%>
<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <% 
    
	  String cid = (String) session.getAttribute("USERID");
      if( cid == null )
      {
    	  response.sendRedirect("home11.jsp");
      }
		
    %> 
    


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet"type="text/css"href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
        <title>View Order Customer</title>
      <style>
     body {
	font-family: Arial, Helvetica, sans-serif;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 30%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
  </style>
    </head>
    <body>
     
   <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <!--<a class="navbar-brand" href="#">Logo</a> -->
    </div>
   
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       		 <li class="active"><a href="customercon11.jsp">Home</a></li>
      </ul>
      
        
        <!--<li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--->
     
    </div>
  </div>
</nav>

 
    <div class="site-blocks-cover inner-page" style="background-image: url('https://wallpaperbat.com/img/417900-pharmacist-wallpaper.jpg');">
         <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> Orders For You</h2><br>
                    </div>
                </div>
            </div>
             <table class="table table-striped table-hover table-bordered" id="table_id">
                <thead>
                    <tr>
                        <th>OrderId</th>
                        <th>CustomerId</th>
                        <th>ProductId</th>
                        <th>OrderedUnits</th>
                        <th>Price</th>
                        <th>Address</th>
                        <th>Ordered Date</th>
                        <th>Requested Date</th>
                        <th>Accepted</th>
                        <th>Confirmed</th>
                        <th>Cancelled</th>
                        <th>Action</th>                   
                        
                    </tr>
                </thead>
                <tbody>
                
       

           
                    <%
                    String custid = null;
                    if(!session.isNew() || session.getAttribute("USERID") != null)
                    {
                    	 custid = (String) session.getAttribute("USERID");
                    %>
                    <% 
                    

                            OrderDAO dao = new OrderDAO();
                            
                            List<Order> lst = dao.getAllOrderdetailsforCustomer(custid);

                            if(lst.size() > 0)
                            {
                            for (Order qs : lst) {
                    %>
                    <tr>

                        <td><%=qs.getOrderid()%></td>

                        <td><%=qs.getCustid()%></td>
                        
                        <td><%=qs.getProductid()%></td>
                        
                        <td><%=qs.getOrderedunits()%></td>
                        
                        <td><%=qs.getPrice()%></td>

                        <td><%=qs.getAddress()%></td>
                        
                        <td><%=qs.getOrdereddate()%></td>
                        
                        <td><%=qs.getRequesteddate()%></td>

                        <td><%=qs.isAccepted()%></td>
                        
                        <td><%=qs.isConfirmed()%></td>
                        
                        <td><%=qs.isCancelled()%></td>
                        
                         <td>
                            <form action="denyorder.jsp" method="post">
                            <input type="hidden" name="OrderId" value="<%=qs.getOrderid()%>"/>
                            <input class = "btn btn-danger" type="submit" value="Deny order"/>
                            </form>
                        </td>   
                  
                   </tr>
                <%}}%>
                </tbody>
            </table>
            
            <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
            <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
            
            <script> $(function() {
            	$("#table_id").dataTable();
            	});
            </script>
            
        </div>
         </div>

                
          
                  <br><br>
 <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">

            <div class="block-7">
              <h3 class="footer-heading mb-4">About Us</h3>
              <p>We are the best pharmacy store available online.</p>
            </div>

          </div>
          <div class="col-lg-3 mx-auto mb-5 mb-lg-0">
            <h3 class="footer-heading mb-4">Why Us?</h3>
            <p>Rated best by the great experts around the corner and whole globe.</p>
          </div>

          <div class="col-md-6 col-lg-3">
            <div class="block-5 mb-5">
              <h3 class="footer-heading mb-4">Contact Info</h3>
              <ul class="list-unstyled">
                <li class="address">222, Kengeri, Bangalore, Karnataka</li>
                <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                <li class="email">emailaddress@domain.com</li>
              </ul>
            </div>


          </div>
        </div>

        </div>
      </div>
    </footer>
  </div>

  
   <% 
        }
                    else{
                    %>
                    <p style=color:red> You need to login first !!! </p>
    				<jsp:include page="home11.jsp"></jsp:include>
                    <%
                    }
                    %>

    </body>
</html>