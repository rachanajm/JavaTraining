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
        <title>Show order list to Admin</title>
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
       		 <li class="active"><a href="admincon111.jsp">Home</a></li>
      </ul>
      
        
        <!--<li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--->
     
    </div>
  </div>
</nav>


    <div class="site-blocks-cover inner-page" style="background-image: url('images/show3.jpg');">
         <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> Order List For You</h2><br>
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
                            OrderDAO dao = new OrderDAO();
                            
                            List<Order> lst = dao.getAllOrderdetails();

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
                        
                        <!--   <td>
                        	<button id="myBtn" class="btn btn-danger"
                        	onclick="openMyDialog(<%=qs.getOrderid()%>)">Accept This Order</button>
                        </td>  -->
                        
                        <td>
                            <form action="adminaccptprodupdate.jsp" method="post">
                            <input type="hidden" name="ProductId" value="<%=qs.getProductid()%>"/>
                            
                            <input type="hidden" name="OrderId" value="<%=qs.getOrderid()%>"/>
                            
                            <input type="hidden" name="OrderedUnits" value="<%=qs.getOrderedunits()%>"/>
                            <input class = "btn btn-danger" type="submit" value="Accept order"/>
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
<!-- Start Of The Modal Design-->
<div class="container" align="center">
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <table class="table table-hover">
       
         <tr>
            <td><button id="btnRaise" class="btn btn-danger" onclick="acceptOrder1()">
            		 Accept Order
            	</button>
            </td>
        </tr>
    </table>
  </div>
</div>
</div>
<!-- End Of The Modal Design-->
        
        <script>

									// Get the modal
									var modal = document
											.getElementById("myModal");

									// Get the button that posts complaint
									var btnRaise = document
											.getElementById("btnRaise");

									// Get the <span> element that closes the modal
									var span = document
											.getElementsByClassName("close")[0];

									var orderid = 0;

									// When the user clicks the button, open the modal 
									function openMyDialog(id) {
										modal.style.display = "block";
										orderid = id;
									}

									function acceptOrder1() {


										var url = "UpdateAccept1.jsp?orderid="
												+ orderid;
												
										modal.style.display = "none";

										if (window.XMLHttpRequest) {
											request = new XMLHttpRequest();
										} else if (window.ActiveXObject) {
											request = new ActiveXObject(
													"Microsoft.XMLHTTP");
										}

										try {
											request.onreadystatechange = getOrderResponse;
											request.open("GET", url, true);
											request.send();
										} catch (e) {
											alert("Unable to connect to server");
										}
									}

									function getOrderResponse() {
										if (request.readyState == 4) {
											var val = request.responseText;
											if (val.trim() == "success") {
												alert("order accepted");
												window.location.reload(true);
											} else {
												alert("order acception failed");
											}
										}
									}

									// When the user clicks on <span> (x), close the modal
									span.onclick = function() {
										modal.style.display = "none";
										alert(productid);
									}

									// When the user clicks anywhere outside of the modal, close it
									window.onclick = function(event) {
										if (event.target == modal) {
											modal.style.display = "none";
										}
									}
								</script>
								
								<br><br>
                
  </div>

    
           

 <!--   <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>-->
            

        
    </body>
</html>