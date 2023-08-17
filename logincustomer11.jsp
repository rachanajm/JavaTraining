<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!doctype html>
<html lang="en">
   <head>
      <title>Login Customer</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="register/css/style.css">
   </head>
   <body>
      <section class="ftco-section">
         <div class="container">
            <div class="row justify-content-center">
               <div class="col-md-6 text-center mb-5">
                  <h2 class="heading-section">Welcome Back, please login to your account!</h2>
               </div>
            </div>
            <div class="row justify-content-center">
               <div class="col-md-12 col-lg-10">
                  <div class="wrap d-md-flex">
                     <div style="background: #09f;" class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
                        <div class="text w-100">
                           <h2>Login customer page</h2>
                        </div>
                     </div>
                     <div class="login-wrap p-4 p-lg-5">
                        <div class="d-flex">
                           <div class="w-100">
                              <h3 class="mb-4">Sign In!</h3>
                           </div>
                        </div>
                        <form action="validatecustomer.jsp" class="form" method="post"onsubmit="return validateData()">
                           <div class="form-group">
                              <label for="customerid">Customer ID:</label>
                              <input type="text" class="form-control" id="customerid" placeholder="Enter Customer ID" name="customerid" required>
                           </div>
                           <div class="form-group">
                              <label for="password">Password:</label>
                              <input type="password" class="form-control" id="password" placeholder="Enter Customer Password" name="password" required>
                           </div>
                           <div class="form-group">
                              <button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>
                           </div>
                        </form>
                        
                     </div>
                  </div>
               </div>
            </div>
         </div>
      
      </section>
      <script src="register/js/jquery.min.js"></script>
      <script src="register/js/popper.js"></script>
      <script src="register/js/bootstrap.min.js"></script>
      <script src="register/js/main.js"></script>
   </body>
</html>