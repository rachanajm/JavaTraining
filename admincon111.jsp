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
      <title>Pharmacy &mdash; Final case study</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
      <link rel="stylesheet" href="fonts/icomoon/style.css">
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/magnific-popup.css">
      <link rel="stylesheet" href="css/jquery-ui.css">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesheet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="css/aos.css">
      <link rel="stylesheet" href="css/style.css">
      
   </head>
   <body>
      <div class="site-wrap">
         <div class="site-navbar py-2">
            <div class="container">
               <div class="d-flex align-items-center justify-content-between">
                  <div class="logo">
                     <div class="site-logo">
                        <a href="home.html" class="js-logo-clone">Pharma</a>
                     </div>
                  </div>
                  <div class="main-nav d-none d-lg-block">
                     <nav class="site-navigation text-right text-md-center" role="navigation">
                        <ul class="site-menu js-clone-nav d-none d-lg-block">
                           <li class=""><a href="logout.jsp">Logout</a></li>
                        </ul>
                     </nav>
                  </div>
               </div>
            </div>
         </div>
         <hr>
         <body>
            <div class="container">
               <h1 style="font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">Hello Admin!</h1>
            </div>
            <div class="site-section bg-secondary bg-image" style="background-image: url('images/bg_2.jpg');">
               <div class="container">
                  <div class="row align-items-stretch">
                     <div class="col-lg-6 mb-5 mb-lg-0">
                        <a href="ShowProductsToAdmin1.jsp" class="banner-1 h-100 d-flex" style="background-image: url('images/bg_1.jpg');">
                           <div class="banner-1-inner align-self-center">
                              <h2>TO SHOW PRODUCT DETAILS</h2>
                              <p>Click here to update product price and quantity.
                              </p>
                           </div>
                        </a>
                     </div>
                     <div class="col-lg-6 mb-5 mb-lg-0">
                        <a href="ShowOrderListToAdmin1.jsp" class="banner-1 h-100 d-flex" style="background-image: url('images/bg_2.jpg');">
                           <div class="banner-1-inner ml-auto  align-self-center">
                              <h2>TO SHOW ORDER LIST</h2>
                              <p>Click here to view and accept the order list.
                              </p>
                           </div>
                        </a>
                     </div>
                     <div style="margin-top: 2%; margin-left: auto; margin-right: auto;"  class="col-lg-6 mb-5 mb-lg-0">
                        <a href="orderiddetailsadmin111.jsp" class="banner-1 h-100 d-flex" style="background-image: url('images/bg_3.jpg');">
                           <div class="banner-1-inner ml-auto  align-self-center">
                              <h2>TO SHOW SPECIFIC DETAILS OF ORDER ID</h2>
                              <p>Click here to view specific details of order ID
                              </p>
                           </div>
                        </a>
                     </div>
                     <div style="margin-top: 2%; margin-left: auto; margin-right: auto;"  class="col-lg-6 mb-5 mb-lg-0">
                        <a href="ShowCancelledOrderListToAdmin.jsp" class="banner-1 h-100 d-flex" style="background-image: url('images/bg_1.jpg');">
                           <div class="banner-1-inner align-self-center">
                              <h2>TO VIEW Cancelled ORDERS</h2>
                              <p>Click here to view cancelled orders.
                              </p>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
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
            </footer>
      </div>
      <script src="js/jquery-3.3.1.min.js"></script>
      <script src="js/jquery-ui.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/owl.carousel.min.js"></script>
      <script src="js/jquery.magnific-popup.min.js"></script>
      <script src="js/aos.js"></script>
      <script src="js/main.js"></script>
      <script type="text/javascript">

      
   </body>
</html>