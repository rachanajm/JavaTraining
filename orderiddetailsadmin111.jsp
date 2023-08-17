<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    
	  String cid = (String) session.getAttribute("USERID");
      if( cid == null )
      {
    	  response.sendRedirect("home11.jsp");

      }

    %> 
    
    
    
    
    
    
    <!DOCTYPE html>
<html lang="en">
<head>
  <title>Specific Order</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      background-color : lightblue;	
      margin-bottom: 0;	
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container">
    <div class="row">
	<div class="col-sm-4 col-xs-6">
		<img class="img-responsive" src="https://png.pngtree.com/template/20190512/ourmid/pngtree-medical-cross-and-health-pharmacy-logo-vector-template-image_148831.jpg" height="200" width="185">
    	</div>
	<div class="col-sm-8 col-xs-6">		
    		<h1>Pharmacy Store</h1>      	
		<p>Bringing the medicine at your door...</p>
	</div>
    </div>	 
  </div>
</div>

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
      
    </div>
  </div>
</nav>
</head>
    <div class="site-blocks-cover inner-page" style="background-image: url('images/show3.jpg');">
    

<div class="container">

  <h2><i>Please enter the order_id!</i></h2>
  <br><br>
  <form action="ShowOrderListToAdminForSpecificId1.jsp" method="post" onsubmit="return validateData()">

    <div class="form-group">
      <label for="orderid">Order Id:</label>
      <input type="text" class="form-control" id="adminid" placeholder="Enter order_id" name="orderid">
    </div>
    <input type="submit" class="btn btn-block btn-info">
  </form>
</div>

</div>
<br><br>


</body>
</html>