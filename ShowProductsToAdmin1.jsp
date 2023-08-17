<%@page import="com.nttdatatraining.dao.ProductDAO"%>
<%@page import="com.nttdatatraining.dto.Product"%>
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
        
        
        <title>Show Products to Admin</title>
        
        
        
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
    
     <div class="site-blocks-cover inner-page" style="background-image: url('images/show10.jpg');">
         <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> Products For You</h2><br>
                    </div>
                </div>
            </div>
            </div>
            
            
            
            <table class="table table-striped table-hover table-bordered" id="table_id">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Category Id</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Description</th>
                       
                        <th>Action </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                            ProductDAO dao = new ProductDAO();
                            
                            List<Product> lst = dao.getAllProducts();

                            if(lst.size() > 0)
                            {
                            for (Product qs : lst) {
                    %>
                    <tr>

                        <td><%=qs.getProductid()%></td>

                        <td><%=qs.getProductname()%></td>
                        <td><%=qs.getCategoryid()%></td>
                        
                        <td>
                            <%=qs.getPrice()%>
                        </td>
                        <td>
                            <%=qs.getQuantity()%>
                        </td>
                        <td><%=qs.getDescription()%></td>
                        
                        
                       
                        
                        <td>
                        	<button id="myBtn" class="btn btn-danger"
                        	onclick="openMyDialog(<%=qs.getProductid()%>)">Update This Product</button>
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
            <th align="center"> <b>Enter Product Details To Be Updated : </b></th>
        </tr>
        <tr>
            <td>
            	<label class="control-label" for="price">Enter price</label> 
                <input type="text" class="form-control" id="price" name="price"/>
            </td>
        </tr>
        <tr>
            <td>
            	<label class="control-label" for="quantity">Enter quantity</label> 
                <input type="text" class="form-control" id="quantity" name="quantity"/>
            </td>
        </tr>
        <tr>
            <td><button id="btnRaise" class="btn btn-danger" onclick="updateProduct()">
            		Update Product
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

									var productid = 0;

									// When the user clicks the button, open the modal 
									function openMyDialog(id) {
										modal.style.display = "block";
										productid = id;
									}

									function updateProduct() {

										var price = document
												.getElementById("price").value;
										
										var quantity = document
										.getElementById("quantity").value;

										var url = "UpdateProduct1.jsp?productid="
												+ productid
												+ "&price="
												+ price
												+ "&quantity="
												+ quantity;

										modal.style.display = "none";

										if (window.XMLHttpRequest) {
											request = new XMLHttpRequest();
										} else if (window.ActiveXObject) {
											request = new ActiveXObject(
													"Microsoft.XMLHTTP");
										}

										try {
											request.onreadystatechange = getProductResponse;
											request.open("GET", url, true);
											request.send();
										} catch (e) {
											alert("Unable to connect to server");
										}
									}

									function getProductResponse() {
										if (request.readyState == 4) {
											var val = request.responseText;
											if (val.trim() == "success") {
												alert("product updated");
												window.location.reload(true);
											} else {
												alert("product update failed");
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
								

        
    </body>
</html>